package exercise3;

public class FibonacciCalculator implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            long fib = MathUtils.fibonacci(i);
            System.out.printf("[%tT] Thread-%d (%s): Fibonacci(%d) = %d%n",
                    System.currentTimeMillis(), Thread.currentThread().getId(),
                    Thread.currentThread().getName(), i, fib);
            MathUtils.randomDelay();
        }
    }
}