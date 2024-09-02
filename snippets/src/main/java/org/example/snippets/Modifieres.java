package org.example.snippets;

public class Modifieres {
    public static int LENGTH = 5;

    static {
        LENGTH = 10;
    }

    public static void swing() {
        System.out.print("swing ");
    }

}
