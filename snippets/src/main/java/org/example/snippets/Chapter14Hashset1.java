package org.example.snippets;

import java.util.HashSet;
import java.util.Iterator;

public class Chapter14Hashset1 {
    public static void main(String[] args) {
        var numbers = new HashSet<Number>();
        numbers.add(Integer.valueOf(86));
        numbers.add(75);
        numbers.add(Integer.valueOf(86));
        numbers.add(null);
        numbers.add(309L);
        Iterator iter = numbers.iterator();
        while (iter.hasNext())
            System.out.print(iter.next());
    }
}
