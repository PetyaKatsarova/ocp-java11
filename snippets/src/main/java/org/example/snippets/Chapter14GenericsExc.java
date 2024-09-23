package org.example.snippets;

import java.util.ArrayList;
import java.util.List;

public class Chapter14GenericsExc {
    static void printNames(List list) {
        for (int i = 0; i < list.size(); i++) {
            String name =  (String) list.get(i); // ClassCastException
            System.out.println(name);
        }
    }
    public static void main(String[] args) {
        List names = new ArrayList();
        names.add(new String("Webby"));
        printNames(names);
        names.add(new StringBuilder("Webby"));
        printNames(names); // this one causes the exception on row 9
    }
}
