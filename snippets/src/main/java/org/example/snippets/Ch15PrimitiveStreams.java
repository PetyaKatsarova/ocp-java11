package org.example.snippets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.*;
import java.util.IntSummaryStatistics;

public class Ch15PrimitiveStreams {
    public static void main(String[] args) {
        System.out.println(IntStream.of(1, 2, 3).average().getAsDouble());  // 2.0

        System.out.println("-- RANGE -- ");
        IntStream.range(1, 6).forEach(System.out::print);
        System.out.println("\n-- rangeClosed --");
        IntStream.rangeClosed(1, 5).forEach(System.out::print);

        System.out.println("-- FLAT MAP --");
//        ArrayList<Integer> integerList = new ArrayList<>();
//        IntStream ints       = integerList.stream().flatMapToInt(x -> IntStream.of(x));
//        DoubleStream doubles = integerList.stream().flatMapToDouble(x -> DoubleStream.of(x));
//        LongStream longs     = integerList.stream().flatMapToLong(x -> LongStream.of(x));

        // PRIMITIVE STREAMS
        int[][] array = {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8, 9}
        };
        System.out.println("Flattened IntStream values:");
        Arrays.stream(array).flatMapToInt(IntStream::of).forEach(System.out::print);

        IntStream intStream = IntStream.range(1, 6);
        // Convert each int to a custom object (String in this case)
        List<String> list = intStream.mapToObj(i -> "Number: " + i).collect(Collectors.toList());
        list.forEach(System.out::println);

        LongStream longs = LongStream.of(5, 10);
        long sum = longs.sum();
        System.out.println(sum);     // 15
        DoubleStream doubles = DoubleStream.generate(() -> Math.PI);
        System.out.println("waiting b4....");
//        OptionalDouble min = doubles.min(); // runs infinitely
        System.out.println("waiting....");
//        System.out.println(min);

        var integerList = new ArrayList<Integer>();
        IntStream ints = integerList.stream().flatMapToInt(x -> IntStream.of(x));
        IntSummaryStatistics stats = ints.summaryStatistics();
        System.out.println(stats);
        if (stats.getCount() == 0) throw new RuntimeException();
        System.out.println(stats.getMax() - stats.getMin());
    }
}
