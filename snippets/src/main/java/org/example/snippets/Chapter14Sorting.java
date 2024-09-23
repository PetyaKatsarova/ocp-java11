package org.example.snippets;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Chapter14Sorting {

    public static void main(String[] args) {
        var names = Arrays.asList("Fluffy", "Hoppy");
        Comparator<String> c = Comparator.reverseOrder();
        System.out.println(c);
        System.out.println(names);
        // bellow row sorts reverse using the c, if removed result is -1: The reverseOrder() comparator expects the list in descending order, so binary search will give incorrect results.
        Collections.sort(names, c);  // Sort the list in reverse order
        var index = Collections.binarySearch(names, "Hoppy", c);
        System.out.println(index);
    }
}

