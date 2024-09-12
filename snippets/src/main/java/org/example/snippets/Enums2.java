package org.example.snippets;

/**
 * The first time that we ask for any of the enum values, Java constructs all of the enum values. After that, Java just returns the already constructed enum values.
 * */
public class Enums2 {
    public static void main(String[] args) {
        System.out.print("begin,");
        OnlyOne firstCall = OnlyOne.ONCE;  // prints constructing,
        OnlyOne secondCall = OnlyOne.ONCE; // doesn't print anything
        System.out.print("end");
    }
}
enum OnlyOne {
    ONCE(true);
    private OnlyOne(boolean b) {
        System.out.print("constructing,");
    }
}
