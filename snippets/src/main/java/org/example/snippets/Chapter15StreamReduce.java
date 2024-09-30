package org.example.snippets;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Chapter15StreamReduce {
}
class ReduceExamples {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // 1. T reduce(T identity, BinaryOperator<T> accumulator)
        // Sum of the numbers using an identity of 0
        int sum = numbers.stream().reduce(0, Integer::sum);  // T is Integer
        System.out.println("Sum with identity: " + sum); // Output: Sum with identity: 15

        // 2. Optional<T> reduce(BinaryOperator<T> accumulator)
        // Sum of the numbers without an identity
        Optional<Integer> optionalSum = numbers.stream().reduce(Integer::sum); // T is Integer
        optionalSum.ifPresent(s -> System.out.println("Sum without identity: " + s)); // Output: Sum without identity: 15

        // 3. <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)
        // Example: Combine the numbers into a String
        String result = numbers.stream().reduce("", (str, num) -> str + num, String::concat);           // BinaryOperator<U>: Combiner for parallel streams
        System.out.println("Reduced to string: " + result); // Output: Reduced to string: 12345

        System.out.println("--- REDUCE 3 PARAMS --------");
        Stream<String> stream = Stream.of("w", "o", "l", "f!");
        int length = stream.reduce(0, (i, s) -> i + s.length()*2, Integer::sum);
//        int length = stream.reduce(0, (i, s) -> i + s.length(), (a, b) -> a + b);
        System.out.println(length); // 10
    }
}

