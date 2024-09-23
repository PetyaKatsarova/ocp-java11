package org.example.snippets;
import java.util.function.Predicate;

public class MethodRef {
    public static void main(String[] args) {
        String str = "abc";
        Predicate<String> methodRef = str::startsWith;
        Predicate<String> lambda = s -> str.startsWith(s);

        System.out.println("Method reference result: " + methodRef.test("a"));  // true
        System.out.println("Lambda expression result: " + lambda.test("a"));   // true

        System.out.println("Method reference result: " + methodRef.test("b"));  // false
        System.out.println("Lambda expression result: " + lambda.test("b"));   // false
    }
}


