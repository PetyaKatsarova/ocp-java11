package org.example.snippets;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Chapter14ConstructorRef {
    public static void main(String[] args) {
        Function<Integer, List<String>> methodRef = ArrayList::new; // Integer is array capacity
        Function<Integer, List<String>> lambda = x -> new ArrayList<>(x);

        List<String> listMethodRef = methodRef.apply(5);
        List<String> listLambda = lambda.apply(5);
        listMethodRef.add("Method Reference");
        listLambda.add("Lambda Expression");

        System.out.println("List created with method reference: " + listMethodRef);
        System.out.println("List created with lambda expression: " + listLambda);
    }
}


