package technical.java.worker;

import java.util.ArrayList;
import java.util.List;

public class TryWorkerFixWithChunking {
    static int globalTotal = 0;

    synchronized static void addToGlobal(int localSum) {
        globalTotal += localSum;
    }

    static class Worker extends Thread {
        List<Integer> chunk;

        Worker(List<Integer> chunk) {
            this.chunk = chunk;
        }

        public void run() {
            // 1. LOCAL VARIABLE (Stack Memory)
            // No other thread can see this. No locking needed!
            int localSum = 0; 
            
            for (Integer num : chunk) {
                localSum++; // Super fast
            }

            // 2. Update Global ONLY ONCE at the end
            addToGlobal(localSum); 
        }
    }

    public static void MainChunkWorker(List<Integer> numbers) throws InterruptedException {
        // 1. Determine number of workers (e.g., 4 cores)
        int numThreads = 8;
        int chunkSize = numbers.size() / numThreads;
        List<Worker> workers = new ArrayList<>();

        long start = System.nanoTime();

        // 2. Create and Start Workers
        for (int i = 0; i < numThreads; i++) {
            int startIdx = i * chunkSize;
            int endIdx = (i == numThreads - 1) ? numbers.size() : (i + 1) * chunkSize;
            
            // Give each worker their own slice of the list
            List<Integer> subList = numbers.subList(startIdx, endIdx);
            Worker w = new Worker(subList);
            workers.add(w);
            w.start();
        }

        // 3. Wait for all to finish (Join)
        for (Worker w : workers) {
            w.join();
        }

        long end = System.nanoTime();
        
        System.out.println("Final Counter: " + globalTotal);
        System.out.println("Time: " + (end - start) / 1_000_000.0 + " ms");
    }
}