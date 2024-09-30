package org.example.snippets;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ch15AdvStreams2 {
    public static void main(String[] args) {
        String result = Stream.of("lions", "tigers", "bears").collect(Collectors.joining(", "));
        System.out.println(result); // lions, tigers, bears

        Double result2 = Stream.of("lions", "tigers", "bears").collect(Collectors.averagingInt(String::length));
        System.out.println(result2); // 5.333333333333333

        TreeSet<String> result3 = Stream.of("lions2", "tigers2", "bears2").filter(s -> s.startsWith("t")).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(result3); // [tigers]

        //var ohMy = Stream.of("lions", "tigers", "bears");
        Map<String, Integer> map = Stream.of("lions", "tigers", "bears").collect(Collectors.toMap(s -> s, String::length)); // key=string, val=str.len
        System.out.println(map); // {lions=5, bears=5, tigers=6}

//        Map<Integer, String> map2 = Stream.of("lions", "tigers", "bears").collect(Collectors.toMap( String::length, k -> k)); // BAD
      //  System.out.println(map2); //Exception in thread "main" java.lang.IllegalStateException: Duplicate key 5 (attempted merging values lions and bears)

        /* !!!
         *  Merge Function ((s1, s2) -> s1 + "," + s2):
         * used to resolve key conflicts when two strings have the same length (i.e., when they produce the same key).
         * If two strings have the same length, the lambda concatenates them, separated by a comma. For example:
         * If "lions" and "bears" both have a length of 5, instead of throwing an exception, the merge function will combine them as "lions,bears".
         */
        Map<Integer, String> map3 = Stream.of("lions1", "tigers", "bears").collect(Collectors.toMap( String::length, k -> k, (s1, s2) -> s1 + "," + s2));
        System.out.println(map3);            // {5=lions,bears, 6=tigers}
        System.out.println(map3.getClass()); // class java.util.HashMap

        Map<Integer, String> map4 = Stream.of("lions1", "tigers", "bears").collect(Collectors.toMap( String::length, k -> k, (s1, s2) -> s1 + "," + s2, TreeMap::new));
        System.out.println(map4);            // {5=lions,bears, 6=tigers}
        System.out.println(map4.getClass()); // class java.util.TreeMap

        Map<Integer, List<String>> map5 = Stream.of("lions", "tigers", "bears").collect( Collectors.groupingBy(String::length));
        System.out.println(map5);    // {5=[lions, bears], 6=[tigers]} //Note that the function you call in groupingBy() cannot return null. It does not allow null keys.

        //Suppose that we don't want a List as the value in the map and prefer a Set instead.
        Map<Integer, Set<String>> map6 = Stream.of("lions", "tigers", "bears").collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println(map6);    // {5=[lions, bears], 6=[tigers]};

        Map<Boolean, List<String>> map7 = Stream.of("lions", "tigers", "bears").collect(
                Collectors.partitioningBy(s -> s.length() <= 5));
        System.out.println(map7);    // {false=[tigers], true=[lions, bears]}

        Map<Integer, Long> map8 = Stream.of("lions", "tigers", "bears").collect(
                Collectors.groupingBy(
                        String::length,
                        Collectors.counting()));
        System.out.println(map8);    // {5=2, 6=1}

        Map<Integer, Optional<Character>> map9 = Stream.of("lions", "tigers", "bears").collect(
                Collectors.groupingBy(
                        String::length,
                        Collectors.mapping(
                                s -> s.charAt(0),
                                Collectors.minBy((a, b) -> a -b))));
        System.out.println(map9);    // {5=Optional[b], 6=Optional[t]}
    }
}
