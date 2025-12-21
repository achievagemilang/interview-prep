package technical.java;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TryConcurrency {
    
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        
        Thread loadingThread = new Thread(() -> {
            char[] spinner = {'|', '/', '-', '\\'};
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.print("\rLoading " + spinner[i % spinner.length] + " ");
                    Thread.sleep(100);
                    i++;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            System.out.print("\rLoading done!     \n");
        });

        Runnable task = () -> {
            loadingThread.start();
            try {
                System.out.println("Task started.");
                Thread.sleep(5000); 
            } catch (InterruptedException e) {
                System.out.println("Task interrupted: " + e.getMessage());
            } finally {
                var executor = Executors.newVirtualThreadPerTaskExecutor();
                Future<Object> future = executor.submit(() -> {
                    loadingThread.interrupt();
                    return null;
                });
                try{
                    future.get();
                } catch(Exception e){
                    System.out.println("Error stopping loading thread: " + e.getMessage());
                }
                executor.shutdown();
                latch.countDown();
            }
            System.out.println("Task completed.");
        };

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Waiting for task to complete...");

        try{
            latch.await();
        } catch (InterruptedException e){
            System.out.println("Thread interrupted: " + e.getMessage());
        }
        System.out.println("All tasks completed.");
    }
}
