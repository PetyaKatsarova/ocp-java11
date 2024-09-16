package org.example.snippets;

public class Lamba2 {
    public static void main(String[] args) {
//        check((h, l) -> h.toString(), 5);  // m1 wrong from the test
        check((h, l) -> h > l, 5);
    }
    private static void check(Sing sing, int volume) {
        if (sing.isTooLoud(volume, 10))   // m2
            System.out.println("not so great");
        else System.out.println("great");
    }
}
interface Sing {
    boolean isTooLoud(int volume, int limit);
}

