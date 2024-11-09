package exercise3;

public class SingleCalculation implements Runnable {
    private final String type;
    private final int number;

    public SingleCalculation(String type, int number) {
        this.type = type;
        this.number = number;
    }

    @Override
    public void run() {
        switch (type) {
            case "PRIME" -> {
                long result = MathUtils.findNthPrime(number);
                System.out.printf("[%tT] Thread-%d (%s): %dth prime = %d%n",
                        System.currentTimeMillis(), Thread.currentThread().getId(),
                        Thread.currentThread().getName(), number, result);
            }
            case "FIBONACCI" -> {
                long result = MathUtils.fibonacci(number);
                System.out.printf("[%tT] Thread-%d (%s): Fibonacci(%d) = %d%n",
                        System.currentTimeMillis(), Thread.currentThread().getId(),
                        Thread.currentThread().getName(), number, result);
            }
            case "FACTORIAL" -> {
                var result = MathUtils.factorial(number);
                System.out.printf("[%tT] Thread-%d (%s): %d! = %s%n",
                        System.currentTimeMillis(), Thread.currentThread().getId(),
                        Thread.currentThread().getName(), number, result.toString());
            }
        }
        MathUtils.randomDelay();
    }
}