package org.example.snippets;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.function.Predicate;

public class Chapter15Optional {

    public static Optional<Double> average(int... scores) {
        if (scores.length == 0)  return Optional.empty();
        int sum = 0;
        for (int score: scores) sum += score;
        return Optional.of((double) sum / scores.length);
    }

    public static void main(String[] args) {
        System.out.println(average(90, 100)); // Optional[95.0]
        System.out.println(average());        // Optional.empty
        Optional<Double> opt = average(90, 100);
//        if (opt.isPresent())
//                System.out.println(opt.get()); // 95.0
        opt.ifPresent(System.out::println); // same as above
        Optional<Double> opt2 = average();
//        System.out.println(opt2.get()); // NoSuchElementException

        String value = "bla";
        String value2 = null;
        Optional o = (value == null) ? Optional.empty() : Optional.of(value);
        Optional o2 = Optional.ofNullable(value2);
        System.out.println(o);
        System.out.println(o2);
    }

}
