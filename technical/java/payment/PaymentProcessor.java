package technical.java.payment;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

// 1. Define the Interface (Dependency Injection)
interface PaymentGatewayItf {
    boolean charge(String bookingId, BigDecimal amount) throws Exception;
}

class PaymentGateway implements PaymentGatewayItf {
    private User user;

    public PaymentGateway(User user) {
        this.user = user;
    }

    @Override
    public boolean charge(String bookingId, BigDecimal amount) throws Exception {
        user.setBalance(user.getBalance().subtract(amount));  
        return true;
    }
}

// 2. Custom Exception for clarity
class PaymentException extends Exception {
    public PaymentException(String message, Throwable cause) {
        super(message, cause);
    }
}

class User {
    private String userId;
    private String name;
    private BigDecimal balance;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.balance = BigDecimal.ZERO;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    // Pesimistic update by locking the setBalance -> avoid race condition (ideally use DB transaction locking)
    // Alternatively, use versioning for optimistic locking (on DB), if somehow version mismatch, retry the whole read-modify-write operation -> need to keep track of queued updates
    public synchronized void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

public class PaymentProcessor {
    private final PaymentGatewayItf gateway;
    // Use a static logger
    private static final Logger logger = Logger.getLogger(PaymentProcessor.class.getName());

    public PaymentProcessor(PaymentGatewayItf gateway) {
        this.gateway = gateway;
    }

    public boolean processBooking(String bookingId, BigDecimal amount) throws PaymentException {
        // 1. Input Validation (Defensive Coding)
        // Note: compareTo is used for BigDecimal. (val <= 0)
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid amount: " + amount + " for booking " + bookingId);
        }
        if (bookingId == null || bookingId.isEmpty()) {
            throw new IllegalArgumentException("Invalid booking ID");
        }

        try {
            // 2. Logging (Observability)
            logger.info("[INFO] Initiating payment for Booking " + bookingId);

            // Simulate gateway error
            // throw new Exception("Simulated gateway failure");

            // 3. Core Logic
            boolean success = this.gateway.charge(bookingId, amount);

            if (!success) {
                logger.warning("[WARN] Payment declined for Booking " + bookingId);
                return false;
            }

            logger.info("[SUCCESS] Payment complete for Booking " + bookingId);
            return true;

        } catch (Exception e) {
            // 4. Error Handling & Retry Logic
            // In a real system, you might catch specific TimeoutExceptions differently
            logger.log(Level.SEVERE, "[ERROR] Gateway failure for " + bookingId, e);
            
            // Wrap and rethrow so the controller knows something went wrong
            throw new PaymentException("Payment processing failed due to gateway error", e);
        }
    }

    public static void main(String[] args) {
        User user = new User("user-1", "John Doe");
        user.setBalance(new BigDecimal("500.00"));
        PaymentGatewayItf mockGateway = new PaymentGateway(user);

        PaymentProcessor processor = new PaymentProcessor(mockGateway);
        try {
            boolean result = processor.processBooking("BK123", new BigDecimal("100.00"));
            System.out.println("Payment result: " + result);
            System.out.println("User new balance: " + user.getBalance());
        } catch (PaymentException e) {
            System.err.println("Payment failed: " + e.getMessage());
        }
    }
}