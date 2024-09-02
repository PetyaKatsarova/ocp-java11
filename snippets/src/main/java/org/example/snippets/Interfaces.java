package org.example.snippets;

public class Interfaces {
}
interface Dances {
    String swingArms();
}
interface EatsFish {
    CharSequence swingArms();
}

class Penguin implements Dances, EatsFish {
    public String swingArms() { // doesnt compile with CharSequence: only covariat of both as return type
        return "swing!";
    }

    public static void main(String[] args) {
        System.out.println(new Penguin().swingArms());
    }
}

