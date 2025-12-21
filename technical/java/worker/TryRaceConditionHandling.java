package technical.java.worker;

import java.util.ArrayList;
import java.util.List;

public class TryRaceConditionHandling {
    static int counter = 0;

    // Synchronized method to safely increment the counter -> handle race conditions
    synchronized static void increment(int workerId) {
        counter++;
        // System.out.print(counter + " " + "(from worker " + workerId + ")\n");
    }


    public static void main(String[] args) throws InterruptedException {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10_000_000; i++) {
            numbers.add(i);
        }

        // --- SAFE (Sequential) ---
        // Guaranteed to print in order: 1 2 3 ...
        // More slower due to lack of parallelism
        System.out.println("Sequential:");
        long startTime = System.nanoTime();
        numbers.stream().forEach(n -> increment(n));
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Final Counter: " + counter);
        System.out.println("Time taken: " + (duration / 1_000_000.0) + " ms");

        
        // --- FAST BUT DISORDERED (Parallel) ---
        // Might print: 6 5 8 1 2 9 ...
        // Much faster due to parallelism
        // Race conditions are handled by synchronized method
        // Which introduce new bottlenecks due to locking -> spend most of the time waiting until one thread releases the lock
        System.out.println("\n\nParallel:");
        counter = 0;
        startTime = System.nanoTime();
        numbers.parallelStream().forEach(n -> increment(n));
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Final Counter: " + counter);
        System.out.println("Time taken: " + (duration / 1_000_000.0) + " ms");


        System.out.println("\n\nFixed Parallel:");
        TryWorkerFixWithChunking.MainChunkWorker(numbers);

    }   
}
