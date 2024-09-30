package org.example.snippets;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Ch15UnaryOp {
    public static void main(String[] args) {
        UnaryOperator<String> u1 = String::toUpperCase;
        UnaryOperator<String> u2 = x -> x.toUpperCase();

        System.out.println(u1.apply("chirp"));  // CHIRP
        System.out.println(u2.apply("chirp"));  // CHIRP
//        We don't need to specify the return type in the generics because UnaryOperator requires it to be the same as the parameter.

        BinaryOperator<String> b1 = String::concat;
        BinaryOperator<String> b2 = (string, toAdd) -> string.concat(toAdd);

        System.out.println(b1.apply("baby ", "chick")); // baby chick
        System.out.println(b2.apply("baby ", "chick")); // baby chick
    }
}

