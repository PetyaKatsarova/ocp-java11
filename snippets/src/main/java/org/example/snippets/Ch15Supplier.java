package org.example.snippets;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Supplier;

public class Ch15Supplier {
    public static void main(String[] args) {
        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = () -> LocalDate.now();

        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();

        System.out.println(d1);
        System.out.println(d2);

        System.out.println("---- EXAMPLE 2 -----------------");
        Supplier<StringBuilder> s11 = StringBuilder::new;
        Supplier<StringBuilder> s12 = () -> new StringBuilder();

        System.out.println(s1.get()); // no output: empty sb
        System.out.println(s2.get());

        Supplier<ArrayList<String>> s13 = ArrayList<String>::new;
        ArrayList<String> a13 = s13.get();
        System.out.println("-- a13: " + a13); // []
        System.out.println("-- s13: " + s13); // org.example.snippets.Ch15Supplier$$Lambda$20/0x00000008000a0440@13a57a3b


        System.out.println("-- EXAMPLE 3 CONSUMER: -----------------");

        }
    }

@FunctionalInterface
interface Consumer<T> {
    void accept(T t);
    // omitted default method
}

@FunctionalInterface
interface BiConsumer<T, U> {
    void accept(T t, U u);
    // omitted default method
}

