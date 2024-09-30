package org.example.snippets;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Chapter15Streams {
    public static void main(String[] args) {
        List<String> zero = List.of();
        var one = List.of("Bonobo");
        var two = List.of("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);

        animals.flatMap(m -> m.stream()).forEach(System.out::println);
//        animals.flatMap(Collection::stream).forEach(System.out::println); // method reference
//        animals.forEach(System.out::print); //[][Bonobo][Mama Gorilla, Baby Gorilla]

        Stream.of("brown-", "bear-").sorted().forEach(System.out::print); // bear-brown-
        Stream.of("brown-", "bear-").sorted(Comparator.reverseOrder()).forEach(System.out::print); // brown-bear-

        System.out.println("\n-- PEEK --");
        long count = Stream.of("black bear", "brown bear", "grizzly").filter(s -> s.startsWith("g")).peek(System.out::println).count();// grizzly
        System.out.println(count);   // 1

        List.of("Toby", "Anna", "Leroy", "Alex").stream().filter(n -> n.length() == 4).sorted().limit(2).forEach(System.out::println);

        Stream.iterate(1, x -> x + 1).limit(5).peek(System.out::print).filter(x -> x % 2 == 1).forEach(System.out::print); // 11233455
        System.out.println(" \n-- filter - limit(5) ----------");
        Stream.iterate(1, x -> x + 1).filter(x -> x % 2 == 1).peek(System.out::print).limit(5).forEach(System.out::print); // 1133557799
    }
}
