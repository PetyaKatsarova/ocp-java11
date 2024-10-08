package org.example.snippets;

import java.util.Arrays;
import java.util.Comparator;

public class Chapter14Comparator {
}

class MyComparator implements Comparator<String> {
    public int compare(String a, String b) { // num, capital, lowercase
        return a.compareTo(b);
    }

    public static void main(String[] args) {
        String[] values = {"123", "Abb", "aab"};
        Arrays.sort(values, new MyComparator());
        for (var s : values)
            System.out.print(s + " ");
    }
}
