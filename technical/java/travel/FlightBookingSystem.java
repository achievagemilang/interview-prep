package technical.java.travel;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Production-Ready Flight Booking Service Implementation.
 * * Features implemented from the Case Study:
 * 1. Idempotency (prevent double-charging).
 * 2. Redis Distributed Lock (Simulated) for the temporary "Hold".
 * 3. Optimistic Locking for the final Database Commit.
 * 4. Comprehensive Logging and Error Handling.
 */

class SeatUnavailableException extends Exception{
    static final String message = "Seat is currently unavailable.";
    public SeatUnavailableException() {
        super(message);
    }
}

class PaymentFailedException extends Exception{
    static final String message = "Payment processing failed.";
    public PaymentFailedException() {
        super(message);
    }
}

class OptimisticLockException extends Exception{
    static final String message = "Optimistic lock failure during booking commit.";
    public OptimisticLockException() {
        super(message);
    }
}

public class FlightBookingSystem {

    private static final Logger logger = Logger.getLogger(FlightBookingSystem.class.getName());

    // Mocks for external dependencies (In a real app, these would be injected)
    private final RedisCache redis;
    private final Database db;
    private final PaymentGateway paymentGateway;

    public FlightBookingSystem() {
        this.redis = new RedisCache();
        this.db = new Database();
        this.paymentGateway = new PaymentGateway();
    }

    /**
     * Main Entry Point: Attempts to book a seat for a user.
     * * @param userId The ID of the user booking the flight.
     * @param flightId The ID of the flight.
     * @param seatNumber The seat (e.g., "1A").
     * @param idempotencyKey Unique key from client to prevent duplicate processing.
     * @return BookingResult containing status and message.
     */
    public BookingResult bookFlight(String userId, String flightId, String seatNumber, String idempotencyKey) throws Exception {
        String bookingRef = flightId + "_" + seatNumber;

        // 1. Idempotency Check
        // If we processed this key already, return the cached result immediately.
        if (redis.hasProcessed(idempotencyKey)) {
            logger.info("[IDEMPOTENCY] Returning cached response for key: " + idempotencyKey);
            return redis.getCachedResult(idempotencyKey);
        }

        try {
            logger.info(String.format("[START] Processing booking %s for user %s", bookingRef, userId));

            // 2. STEP A: The "Hold" (Redis Distributed Lock)
            // We try to acquire a temporary hold on the seat for 5 minutes (300s).
            boolean locked = redis.acquireLock(bookingRef, userId, 300);
            
            if (!locked) {
                throw new SeatUnavailableException();
            }

            logger.info("[HOLD ACQUIRED] Seat held in Redis. Proceeding to payment.");

            // 3. Process Payment (External API)
            // In a real system, this might take a few seconds.
            boolean paymentSuccess = paymentGateway.chargeUser(userId, new BigDecimal("150.00"));

            if (!paymentSuccess) {
                // Release the hold if payment fails so others can book it
                redis.releaseLock(bookingRef);
                throw new PaymentFailedException();
            }

            // 4. STEP B: The "Book" (Persistent DB Write with Optimistic Locking)
            // We now try to make the booking permanent in the SQL Database.
            try {
                // Fetch current version of the seat to ensure no changes happened mid-transaction
                int currentVersion = db.getSeatVersion(flightId, seatNumber);
                
                boolean commitSuccess = db.finalizeBooking(flightId, seatNumber, userId, currentVersion);

                if (!commitSuccess) {
                    // OPTIMISTIC LOCK FAILURE
                    // The DB row version changed between our read and write.
                    // This implies a race condition that bypassed our Redis lock (rare but possible).
                    throw new OptimisticLockException();
                }

                // 5. Success!
                BookingResult successResult = new BookingResult(true, "Booking Confirmed! Seat: " + seatNumber);
                
                // Cache the success result for Idempotency
                redis.cacheResult(idempotencyKey, successResult);
                
                logger.info("[SUCCESS] Booking finalized for " + bookingRef);
                return successResult;

            } 
            catch (OptimisticLockException e){
                // Ideally, we retry the whole booking process a few times before giving up.
                logger.severe("[DB COMMIT FAILED] Optimistic lock error. Auto-refunding user.");
                paymentGateway.refundUser(userId, new BigDecimal("150.00"));
                return new BookingResult(false, "Booking failed due to high traffic. You have been refunded.");
            }
            catch (Exception dbEx) {
                // DB Crash or Connection issue
                logger.log(Level.SEVERE, "[SYSTEM ERROR] Database failure. Initiating refund.", dbEx);
                paymentGateway.refundUser(userId, new BigDecimal("150.00"));
                return new BookingResult(false, "System error. You have been refunded.");
            }

        } catch(SeatUnavailableException e){
            logger.warning("[HOLD FAILED] Seat is currently held by another user: " + bookingRef);
            return new BookingResult(false, e.getMessage());
        } catch (PaymentFailedException e) {
            logger.warning("[PAYMENT FAILED] Payment could not be processed for user: " + userId);
            return new BookingResult(false, e.getMessage());
        }
        catch (Exception e) {
            logger.log(Level.SEVERE, "[CRITICAL] Unexpected system crash", e);
            return new BookingResult(false, "Internal Server Error");
        }
    }

    // ==========================================
    // Mock / Helper Classes to Simulate Infrastructure
    // ==========================================

    /**
     * Represents the Booking Result sent back to the client.
     */
    public static class BookingResult {
        public boolean success;
        public String message;

        public BookingResult(boolean success, String message) {
            this.success = success;
            this.message = message;
        }
    }

    /**
     * Mock Redis Implementation
     * Handles Distributed Locks and Idempotency Caching.
     */
    static class RedisCache {
        private final Map<String, String> locks = new ConcurrentHashMap<>();
        private final Map<String, BookingResult> idempotencyStore = new ConcurrentHashMap<>();

        // Simulates SET resource_key user_id NX EX 300
        public boolean acquireLock(String resource, String owner, int ttlSeconds) {
            return locks.putIfAbsent(resource, owner) == null;
        }

        public void releaseLock(String resource) {
            locks.remove(resource);
        }

        public boolean hasProcessed(String key) {
            return idempotencyStore.containsKey(key);
        }

        public BookingResult getCachedResult(String key) {
            return idempotencyStore.get(key);
        }

        public void cacheResult(String key, BookingResult result) {
            idempotencyStore.put(key, result);
        }
    }

    /**
     * Mock Database Implementation
     * Handles SQL Logic and Optimistic Locking simulation.
     */
    static class Database {
        // Simulates the 'seats' table: Key=Flight_Seat, Value=Version
        private final Map<String, Integer> seatVersions = new ConcurrentHashMap<>();
        // Simulates the 'seats' table status
        private final Map<String, String> seatStatus = new ConcurrentHashMap<>();

        public Database() {
            // Seed data
            seatVersions.put("F101_1A", 1);
            seatStatus.put("F101_1A", "AVAILABLE");
        }

        public int getSeatVersion(String flightId, String seatNumber) {
            return seatVersions.getOrDefault(flightId + "_" + seatNumber, 1);
        }

        /**
         * Simulates the SQL:
         * UPDATE seats SET status='BOOKED', version=version+1 
         * WHERE id=? AND version=?
         */
        public boolean finalizeBooking(String flightId, String seatNumber, String userId, int expectedVersion) {
            String key = flightId + "_" + seatNumber;
            
            synchronized (this) {
                int currentVersion = seatVersions.getOrDefault(key, 1);
                String currentStatus = seatStatus.getOrDefault(key, "AVAILABLE");

                // Optimistic Lock Check
                if (currentVersion != expectedVersion) {
                    return false; // Version mismatch (Someone else wrote to it)
                }
                if (!"AVAILABLE".equals(currentStatus)) {
                    return false; // Logic check
                }

                // Perform Update
                seatVersions.put(key, currentVersion + 1);
                seatStatus.put(key, "BOOKED");
                return true;
            }
        }
    }

    /**
     * Mock Payment Gateway
     */
    static class PaymentGateway {
        public boolean chargeUser(String userId, BigDecimal amount) {
            // Simulate 90% success rate
            return Math.random() > 0.1;
        }

        public void refundUser(String userId, BigDecimal amount) {
            logger.info("Refunding " + amount + " to user " + userId);
        }
    }
}