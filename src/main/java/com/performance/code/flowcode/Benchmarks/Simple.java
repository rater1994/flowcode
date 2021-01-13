package com.performance.code.flowcode.Benchmarks;

import java.util.concurrent.TimeUnit;

public class Simple {

    public static void main(String[] args) {


        System.out.println("Fibonacci iteration:");

        //
        // Start , action and end
        //
        long start = System.nanoTime();

        testMethodProcedurally();

        long elapsedTime = System.nanoTime() - start;

        //
        // Output in different formats: ms, ns, seconds, minutes
        //

        double seconds = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
        double secondDecimalPrecision = (double) elapsedTime / 10000000000.0;
        double ms = TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
        double minutes = TimeUnit.MINUTES.convert(elapsedTime, TimeUnit.NANOSECONDS);

        System.out.printf("Nanoseconds: %d ms\n", elapsedTime);
        System.out.printf("Miliseconds: %f ms\n", ms);
        System.out.printf("Seconds: %f ms\n", seconds);
        System.out.printf("Seconds2: %f ms\n", secondDecimalPrecision);
        System.out.printf("MInutes: %f ms\n", minutes);

    }


    private static int testMethodProcedurally() {
        int number[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        int sum = 0;
        for (int i = 0; i < number.length; i++) {
            sum *= i * i;
        }
        System.out.println("TEST " + sum);
        return sum;
    }
}