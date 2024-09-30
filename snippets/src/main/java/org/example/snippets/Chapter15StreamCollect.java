package org.example.snippets;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.stream.Collectors;
public class Chapter15StreamCollect {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("w", "o", "l", "f");
        StringBuilder word = stream.collect( StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(word); // wolf

        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        List<String> result = words.parallelStream() // Parallel stream
                .collect(ArrayList::new,        // Supplier<R>: Creates a new ArrayList<R>
                        List::add,             // Accumulates elements into the list
                        List::addAll);         // Combines partial results in parallel
        System.out.println(result);

        Stream<String> stream2 = Stream.of("w", "o", "l", "f");
        Stream<String> stream3 = Stream.of("w", "o", "l", "f");
        TreeSet<String> set =  stream2.collect( TreeSet::new, TreeSet::add, TreeSet::addAll);
        TreeSet<String> set2 = stream3.collect(Collectors.toCollection(TreeSet::new)); // cant use again stream2: already been linked or consumed
        System.out.println(set); // [f, l, o, w]
        System.out.println(set2); // [f, l, o, w]

        Stream.of("monkey", "gorilla", "bonobo").map(String::length).forEach(System.out::print); // 676, converts string to int
    }
}

