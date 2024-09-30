package org.example.snippets;

import java.util.ArrayList;
import java.util.Optional;

public class Ch15AdvancedStreams {
    public static void main(String[] args) {
        var cats = new ArrayList<String>();
        cats.add("Annie");
        cats.add("Ripley");
        var stream = cats.stream();
        cats.add("KC");
        System.out.println(stream.count());

        System.out.println("OPTIONAL");
        threeDigit((Optional<Integer>) Optional.of(4242));
        threeDigit((Optional<Integer>) Optional.of(424));
        System.out.println("3 digits2: ");
        threeDigit2(Optional.ofNullable(null));
        threeDigit2(Optional.ofNullable(424));
    }

    private static void threeDigit(Optional<Integer> optional) {
        if (optional.isPresent()) {
            var num = optional.get();
            var string = "" + num;
            if (string.length() == 3)
                System.out.println(string);
        }
    }
    private static void threeDigit2(Optional<Integer> optional) {
        optional.map(n -> "" + n)            // part 1
                .filter(s -> s.length() == 3)     // part 2
                .ifPresent(System.out::println);  // part 3
    }
}
