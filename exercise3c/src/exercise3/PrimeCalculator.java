package exercise3;

public class PrimeCalculator implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 25; i++) {
            long prime = MathUtils.findNthPrime(i);
            System.out.printf("[%tT] Thread-%d (%s): %dth prime = %d%n",
                    System.currentTimeMillis(), Thread.currentThread().getId(),
                    Thread.currentThread().getName(), i, prime);
            MathUtils.randomDelay();
        }
    }
}