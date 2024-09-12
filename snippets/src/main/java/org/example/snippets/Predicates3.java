package org.example.snippets;

import java.util.function.Predicate;

public class Predicates3 {
    public void whatAmI() {
        test((var x) -> x>2, 123);
    }
    public void test(Predicate<Integer> c, int num) {
        System.out.println(c.test(num));
    }

    public static void main(String[] args) {
        new Predicates3().test(p -> p % 2 == 0, 5);
        new Predicates3().whatAmI();
    }
}

