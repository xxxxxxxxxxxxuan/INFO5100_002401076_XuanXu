package exercise3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Part A: Using Traditional Threads\n");
        Thread primeThread = new Thread(new PrimeCalculator(), "PrimeThread");
        Thread fibThread = new Thread(new FibonacciCalculator(), "FibonacciThread");
        Thread factThread = new Thread(new FactorialCalculator(), "FactorialThread");

        primeThread.start();
        fibThread.start();
        factThread.start();

        try {
            primeThread.join();
            fibThread.join();
            factThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nPart B: Using Thread Pool\n");
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 25; i++) {
            executor.submit(new SingleCalculation("PRIME", i));
        }
        for (int i = 1; i <= 50; i++) {
            executor.submit(new SingleCalculation("FIBONACCI", i));
            executor.submit(new SingleCalculation("FACTORIAL", i));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}