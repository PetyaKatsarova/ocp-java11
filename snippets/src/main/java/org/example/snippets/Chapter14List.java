package org.example.snippets;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Chapter14List {
    public static void main(String[] args) {
        var map = Map.of(1, 2, 3, 6);
        var list = List.copyOf(map.entrySet());

        List<Integer> one = List.of(8, 16, 2);
        var copy = List.copyOf(one);
        var copyOfCopy = List.copyOf(copy);
        var thirdCopy = new ArrayList<>(copyOfCopy);

//        list.replaceAll(x -> x * 2); TRICKS FROM EXAM: DONT COMPILE
//        one.replaceAll(x -> x * 2); THROWS OPERATIONNOTALLOWED OR STH ERROR AT RUNTIME
        thirdCopy.replaceAll(x -> x * 2);

        System.out.println(thirdCopy);
    }
}
