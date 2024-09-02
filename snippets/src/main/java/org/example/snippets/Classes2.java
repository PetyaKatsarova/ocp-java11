package org.example.snippets;

public class Classes2 {
}

class Arthropod {
    protected void printName(long input) {
        System.out.print("Arthropod");
    }

    void printName(int input) {
        System.out.print("Spooky");
    }
}

class Spider extends Arthropod {
    protected void printName(int input) {
        System.out.print("Spider");
    }

    public static void main(String[] args) {
        Arthropod a = new Spider();
        a.printName((short) 4);
        a.printName(4);
        a.printName(5L);
    }
}
