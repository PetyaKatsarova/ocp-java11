package org.example.snippets;

import java.util.Arrays;

public class Enums {
    public static void main(String[] args) {
        System.out.println("winter: " + Season.WINTER);
        System.out.println("vals: " + Arrays.toString(Season.values()));
        Season.SUMMER.printExpectedVisitors();
    }
}

enum Season {
    WINTER("Low"), SPRING("Medium"), SUMMER("High"), FALL("Medium");
    private final String expectedVisitors;

    private Season(String expectedVisitors) {
        this.expectedVisitors = expectedVisitors;
    }

    public void printExpectedVisitors() {
        System.out.println(expectedVisitors);
    }
}