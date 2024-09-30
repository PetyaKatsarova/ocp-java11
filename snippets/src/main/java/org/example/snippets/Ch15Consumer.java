package org.example.snippets;

import java.util.HashMap;

public class Ch15Consumer {
    public static void main(String[] args) {
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = x -> System.out.println(x);
        c1.accept("Annie");
        c1.accept("bla bla");
        c1.accept("bla bal bla");
        c2.accept("Annie");

        var map = new HashMap<String, Integer>();
        BiConsumer<String, Integer> b1 = map::put;
        BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);

        b1.accept("chicken", 7);
        b2.accept("chick", 1);

        System.out.println("------------ EXAMPLE 2 ---------------------");
        var map2 = new HashMap<String, Integer>();
        BiConsumer<String, Integer> b11 = map2::put;
        BiConsumer<String, Integer> b12 = (k, v) -> map2.put(k, v);

        b11.accept("chicken", 7);
        b12.accept("chick", 1);

        System.out.println(map2);
    }
}

