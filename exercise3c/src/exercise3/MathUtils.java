package exercise3;

import java.math.BigInteger;

public class MathUtils {
    public static boolean isPrime(long n) {
        if (n <= 1) return false;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static long findNthPrime(int n) {
        if (n <= 0) return -1;
        int count = 0;
        long num = 2;
        while (count < n) {
            if (isPrime(num)) count++;
            if (count == n) return num;
            num++;
        }
        return num - 1;
    }

    public static long fibonacci(int n) {
        if (n <= 1) return n;
        long prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            long next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public static BigInteger factorial(int n) {
        if (n <= 1) return BigInteger.ONE;
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void randomDelay() {
        try {
            Thread.sleep((long) (Math.random() * 401 + 100)); // 100-500ms
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}