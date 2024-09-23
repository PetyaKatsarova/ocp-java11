package org.example.snippets;

import java.util.Random;
import java.util.function.Supplier;

public class Chapter14Supplier {
    public static void main(String[] args) {
        Random random = new Random();
        Supplier<Integer> methodRef = random::nextInt;
        Supplier<Integer> lambda = () -> random.nextInt();

        System.out.println("Random number (method reference): " + methodRef.get());
        System.out.println("Random number (lambda expression): " + lambda.get());
    }
}
