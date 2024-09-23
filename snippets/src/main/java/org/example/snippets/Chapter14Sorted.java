package org.example.snippets;

import java.util.Comparator;
import java.util.TreeSet;

public class Chapter14Sorted {
}

class Sorted implements Comparable<Sorted>, Comparator<Sorted> {
    private int num;
    private String text;
    // Assume getters/setters/constructors provided

    public Sorted(int num, String text) {
        this.num = num;
        this.text = text;
    }

    public String toString() {  return "" + num;  }
    public int compareTo(Sorted s) {   return text.compareTo(s.text);   }
    public int compare(Sorted s1, Sorted s2) {   return s1.num - s2.num;   }

    public static void main(String[] args) {
        var s1 = new Sorted(88, "a");
        var s2 = new Sorted(55, "b");
        var t1 = new TreeSet<Sorted>();
        t1.add(s1);
        t1.add(s2);
        var t2 = new TreeSet<Sorted>(s1);
        t2.add(s1);
        t2.add(s2);
        System.out.println(t1 + " " + t2);

    }
}
