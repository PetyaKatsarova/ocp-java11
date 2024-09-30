package org.example.snippets;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class Chapter15Stream {
    public static void main(String[] args) {
//        Stream<Integer> oddNumUnder100 = Stream.iterate(1, n -> n < 100, n -> n + 2); // overload of iterate
        System.out.println(Stream.iterate(1, n -> n < 100, n -> n + 2)); // output: java.util.stream.ReferencePipeline$Head@48140564
        Stream.iterate(1, n -> n < 100, n -> n + 2).forEach(System.out::println);
    }
}
class StreamExamples {

    public static void main(String[] args) {

        Stream<String> emptyStream = Stream.empty();
        System.out.println("Empty Stream count: " + emptyStream.count()); // Output: 0
        // Stream.of(varargs) Finite: Creates a Stream with elements listed
        Stream<String> streamOf = Stream.of("a", "b", "c");
        System.out.println("Stream.of count: " + streamOf.count()); // Output: 3

        List<String> list = Arrays.asList("one", "two", "three");
        Stream<String> collectionStream = list.stream();
        System.out.println("Collection Stream count: " + collectionStream.count()); // Output: 3

        Stream<String> parallelStream = list.parallelStream();
        System.out.println("Parallel Stream is parallel: " + parallelStream.isParallel()); // Output: true

        // Stream.generate(supplier)
        // Infinite: Creates a Stream by calling the Supplier for each element upon request
        Stream<Double> randomNumbers = Stream.generate(Math::random);
        randomNumbers.limit(5).forEach(System.out::println); // Prints 5 random numbers (infinite, so we limit it)

        // Stream.iterate(seed, unaryOperator)
        // Infinite: Creates a Stream by using the seed for the first element and then the UnaryOperator
        Stream<Integer> iterateStream = Stream.iterate(1, n -> n + 1);
        iterateStream.limit(5).forEach(System.out::println); // Prints: 1, 2, 3, 4, 5 (infinite, so we limit it)

        // Stream.iterate(seed, predicate, unaryOperator)
        // Finite or infinite: Creates a Stream by using the seed and stops when the Predicate returns false
        Stream<Integer> finiteIterateStream = Stream.iterate(1, n -> n <= 5, n -> n + 1);
        finiteIterateStream.forEach(System.out::println); // Prints: 1, 2, 3, 4, 5 (finite because of the predicate)

        Stream<String> s = Stream.of("monkey", "ape", "bonobo");
        Optional<String> min = s.min(Comparator.comparingInt(String::length));
//        Optional<String> min = s.min((s1, s2) -> s1.length()-s2.length());
        min.ifPresent(System.out::println); // ape

        Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);
        System.out.println(minEmpty.isPresent()); // false
        System.out.println(minEmpty); // Optional.empty !!! Since the stream is empty, the comparator is never called

        System.out.println("------------- find any --------------");
        Stream<String> s2 = Stream.of("monkey", "gorilla", "bonobo");
        Stream<String> infinite = Stream.generate(() -> "chimp");

        s2.findAny().ifPresent(System.out::println);        // monkey (usually)
        infinite.findAny().ifPresent(System.out::println); // chimp

        System.out.println("---- FIND ELS ---------");
        var list2 = List.of("monkey", "2", "chimp");
        Stream<String> infinite2 = Stream.generate(() -> "chimp");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));

        System.out.println(list2.stream().anyMatch(pred));  // true
        System.out.println(list2.stream().allMatch(pred));  // false
        System.out.println(list2.stream().noneMatch(pred)); // false
        System.out.println(infinite2.anyMatch(pred));       // true
    }
}

