package org.example.snippets;

import java.util.function.BiPredicate;
public class Chapter14BiPRedicate {
    public static void main(String[] args) {
        BiPredicate<String, String> methodRef = String::startsWith;
        BiPredicate<String, String> lambda = (s, p) -> s.startsWith(p);

        System.out.println("Method reference result: " + methodRef.test("hello", "he"));  // true
        System.out.println("Lambda expression result: " + lambda.test("hello", "he"));   // true

        System.out.println("Method reference result: " + methodRef.test("hello", "lo"));  // false
        System.out.println("Lambda expression result: " + lambda.test("hello", "lo"));   // false
    }
}
