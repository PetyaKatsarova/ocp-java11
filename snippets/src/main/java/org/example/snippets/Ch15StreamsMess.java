package org.example.snippets;

import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
import java.util.Collection;
import java.util.function.Function;

public class Ch15StreamsMess {
    public static void main(String[] args) {
//        Predicate<String> empty = String::isEmpty;
//         Predicate<String> notEmpty = empty.negate();
//
//         var result = Stream.generate(() -> "")
//            .limit(10)
//            .filter(notEmpty)
//            .collect(Collectors.groupingBy(k -> k))
//            .entrySet()
//            .stream()
//            .map(Entry::getValue)
//            .flatMap(Collection::stream)
//            .collect(Collectors.partitioningBy(notEmpty));
//         System.out.println(result);

        var s = DoubleStream.of(1.2, 2.4);
        s.peek(System.out::println).filter(x -> x> 2).count();

        Function<Integer, Integer> s2 = a -> a + 4;
        Function<Integer, Integer> t = a -> a * 3;
        Function<Integer, Integer> c = s2.compose(t); // apply t and pass the result to s2: (1 * 3) + 4 = 7
        System.out.println(c.apply(1));
    }
}
