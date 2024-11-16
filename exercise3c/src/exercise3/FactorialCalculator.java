package exercise3;

import java.math.BigInteger;

public class FactorialCalculator implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            BigInteger fact = MathUtils.factorial(i);
            System.out.printf("[%tT] Thread-%d (%s): %d! = %d%n",
                    System.currentTimeMillis(), Thread.currentThread().getId(),
                    Thread.currentThread().getName(), i, fact);
            MathUtils.randomDelay();
        }
    }
}
