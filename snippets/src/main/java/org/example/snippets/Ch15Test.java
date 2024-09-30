package org.example.snippets;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Ch15Test {
    public static void main(String[] args) {
//        var stream = Stream.iterate("", (s) -> s + "1");
//        System.out.println(stream.limit(2).map(x -> x + "2")); // java.util.stream.ReferencePipeline$3@49e4cb85
        // !!! map() is not terminal operation!! it only transform the data! sets up transformation pipeline; u need forEach, collect, count();
        /*
        * System.out.println(stream.limit(2).map(x -> x + "2"));: Since you're only printing the stream object itself, and not the result of a terminal operation, the stream pipeline itself is displayed (ReferencePipeline$3), rather than the contents.
        * stream.limit(2).map(x -> x + "2").forEach(System.out::println); would work
         * */

        // all r double result =
//  A      LongStream.of(6L, 8L, 10L)
//                .mapToInt(x -> (int) x)
//                .collect(Collectors.groupingBy(x -> x)) //  trying to use Collectors.groupingBy() after a primitive stream (mapToInt()), but Collectors.groupingBy() works with object streams, not primitive streams like IntStream.
//                .keySet()
//                .stream()
//                .collect(Collectors.averagingInt(x -> x));


//   B     LongStream.of(6L, 8L, 10L)
//                .mapToInt(x -> x) // mapToInt(x -> x) is a narrowing conversion from long to int, and this conversion is implicitly safe only for values that fit within the range of int. In this case, since the values in the stream (6L, 8L, 10L) fit within the int range, there are no data loss concerns, but it's still worth noting that casting may lead to unexpected results for larger long values.
//                .boxed()
//                .collect(Collectors.groupingBy(x -> x))
//                .keySet()
//                .stream()
//                .collect(Collectors.averagingInt(x -> x));


        var r = LongStream.of(6L, 8L, 10L)
                .mapToInt(x -> (int) x)
                .boxed()
                .collect(Collectors.groupingBy(x -> x))
                .keySet()
                .stream()
                .collect(Collectors.averagingInt(x -> x));
        System.out.println(r);
        /*
        * LongStream.of(6L, 8L, 10L): Creates a stream of long values (6L, 8L, 10L).
mapToInt(x -> (int) x): Converts each long value into an int value using a cast. In this case, there’s no data loss as the values fit within the int range.
.boxed(): Converts the primitive IntStream into a Stream<Integer>, as the next operations require an object stream.
collect(Collectors.groupingBy(x -> x)): Groups the integers by their values, creating a Map<Integer, List<Integer>>. Since the values are unique (6, 8, and 10), the map looks like:
{
  6=[6],
  8=[8],
  10=[10]
}
.keySet(): Retrieves the keys of the map, which are the unique integers: 6, 8, and 10.
.stream(): Creates a stream from the set of keys.
collect(Collectors.averagingInt(x -> x)): Averages the integers (6, 8, and 10). The result is:
(6 + 8 + 10) / 3 = 8.0
        * */

//        LongStream.of(6L, 8L, 10L)
//                .mapToInt(x -> (int) x)
//                .collect(Collectors.groupingBy(x -> x, Collectors.toSet())) // cant collect on primitive
//                .keySet()
//                .stream()
//                .collect(Collectors.averagingInt(x -> x));
/*
* not getting it
* */

//        LongStream.of(6L, 8L, 10L)
//                .mapToInt(x -> x) //java: incompatible types: bad return type in lambda expression    possible lossy conversion from long to int
//                .boxed()
//                .collect(Collectors.groupingBy(x -> x, Collectors.toSet()))
//                .keySet()
//                .stream()
//                .collect(Collectors.averagingInt(x -> x));

        var r2 = LongStream.of(6L, 8L, 10L)
                .mapToInt(x -> (int) x)
                .boxed()
                .collect(Collectors.groupingBy(x -> x, Collectors.toSet()))
                .keySet()
                .stream()
                .collect(Collectors.averagingInt(x -> x));
        System.out.println(r2);


        /*There is no Stream<T> method called compare() or compareTo(). The sorted() method is correct to use in a stream pipeline to return a sorted Stream. The collect() method can be used to turn the stream into a List. The collect() method requires a collector be selected*/
        var list = new ArrayList<>(List.of("one", "two", "three"));
        var bla = list.stream().sorted((a,b) -> b.compareTo(a)).collect(Collectors.toList());
        System.out.println("list.stream.sorted...: " + bla);

//        var stream = LongStream.of(1, 2, 3); // THIS IS LONG!!
//         System.out.println("Long str.map.filter: " + stream.map(n -> n * 10).filter(n -> n < 5).findFirst());
//        var opt = stream.map(n -> n * 10).filter(n -> n < 5).findFirst();
//        if (opt.isPresent())
//            System.out.println(opt.getAsLong());
    }
}
