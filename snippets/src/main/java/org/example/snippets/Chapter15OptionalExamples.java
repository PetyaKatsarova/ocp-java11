package org.example.snippets;

import java.util.Optional;

public class Chapter15OptionalExamples {
    public static void main(String[] args) {

        Optional<String> optionalWithValue = Optional.of("Hello");
        Optional<String> emptyOptional = Optional.empty();

        // get()
        // When Optional is empty: Throws an exception (NoSuchElementException)
        // When Optional contains a value: Returns the value
        try {
            System.out.println("Value from optionalWithValue: " + optionalWithValue.get()); // Prints: Hello
            System.out.println("Value from emptyOptional: " + emptyOptional.get()); // Throws NoSuchElementException
        } catch (Exception e) {
            System.out.println("Exception from get(): " + e);
        }
        // !!! NB !!! if there was no try/catch the program will terminate here

        // ifPresent(Consumer c)
        // When Optional is empty: Does nothing
        // When Optional contains a value: Calls Consumer with the value
        optionalWithValue.ifPresent(value -> System.out.println("ifPresent value: " + value)); // Prints: Hello
        emptyOptional.ifPresent(value -> System.out.println("This won't print"));

        // isPresent() is boolean
        System.out.println("isPresent for optionalWithValue: " + optionalWithValue.isPresent()); // true
        System.out.println("isPresent for emptyOptional: " + emptyOptional.isPresent()); // false

        // orElse(T other)
        // When Optional is empty: Returns the other parameter
        // When Optional contains a value: Returns the value
        System.out.println("orElse for optionalWithValue: " + optionalWithValue.orElse("Default"));
        System.out.println("orElse for emptyOptional: " + emptyOptional.orElse("Default"));

        // orElseGet(Supplier s)
        // When Optional is empty: Returns the result of calling Supplier
        // When Optional contains a value: Returns the value
        System.out.println("orElseGet for optionalWithValue: " + optionalWithValue.orElseGet(() -> "From Supplier")); // Hello
        System.out.println("orElseGet for emptyOptional: " + emptyOptional.orElseGet(() -> "From Supplier")); // From Supplier

        // orElseThrow()
        // When Optional is empty: Throws NoSuchElementException
        // When Optional contains a value: Returns the value
        try {
            System.out.println("orElseThrow for optionalWithValue: " + optionalWithValue.orElseThrow()); // Hello
            System.out.println("orElseThrow for emptyOptional: " + emptyOptional.orElseThrow()); // Throws NoSuchElementException
        } catch (Exception e) {
            System.out.println("Exception from orElseThrow: " + e);
        }

        // orElseThrow(Supplier s)
        // When Optional is empty: Throws exception created by calling Supplier
        // When Optional contains a value: Returns the value
        try {
            System.out.println("orElseThrow with Supplier for optionalWithValue: " + optionalWithValue.orElseThrow(() -> new IllegalArgumentException("No value"))); // Hello
            System.out.println("orElseThrow with Supplier for emptyOptional: " + emptyOptional.orElseThrow(() -> new IllegalArgumentException("No value"))); // Throws IllegalArgumentException
        } catch (Exception e) {
            System.out.println("Exception from orElseThrow with Supplier: " + e);
        }

        Optional<Double> opt = average();
//        System.out.println(opt.orElseGet(() -> new IllegalStateException())); // DOES NOT COMPILE: cant be converted to double
    }
    public static Optional<Double> average(int... scores) {
        if (scores.length == 0) return Optional.empty();
        int sum = 0;
        for (int score : scores) sum += score;
        return Optional.of((double) sum / scores.length);
    }

}
