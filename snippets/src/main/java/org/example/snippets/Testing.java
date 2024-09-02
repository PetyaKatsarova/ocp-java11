package org.example.snippets;

public class Testing {
}

abstract class Nocturnal {
    abstract boolean isBlind();
}

class Owl extends Nocturnal {
    public boolean isBlind() {
        return false;
    }

    public static void main(String[] args) {
        var nocturnal = (Nocturnal) new Owl();
        System.out.println(nocturnal.isBlind());
        }
}
