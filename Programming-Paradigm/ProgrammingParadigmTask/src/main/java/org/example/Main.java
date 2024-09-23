package org.example;


import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // Function as argument
        int[] numbers = {1, 2, 3, 4, 5};
        myCustomForEach(numbers, (x) -> x + 10);

        System.out.println("-------------------------------");

        FunctionInsideFunction();

        System.out.println("-------------------------------");

        // Function as a return type
        int sum = Sum(2).apply(10);
        System.out.println("Sum = " + sum);

    }

    public static void myCustomForEach(int[] numbers, Function<Integer, Integer> f) {
        for (int number : numbers) {
            System.out.println(f.apply(number));
        }
    }

    public static void FunctionInsideFunction() {
        Runnable runnable = () -> System.out.println("Function inside a function");
        runnable.run();
    }

    public static Function<Integer, Integer> Sum(int x) {
        return (y) -> x + y;
    }
}