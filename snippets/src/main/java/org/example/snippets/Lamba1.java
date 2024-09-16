package org.example.snippets;

public class Lamba1 {
    @FunctionalInterface
    interface MyFunction {
        int apply(int a, int b);
    }

    static void execute(MyFunction f) {
        System.out.println(f.apply(5, 3)); // Executes lambda
    }
    public static void main(String[] args) {
        execute((a, b) -> a * b);
    }
}
