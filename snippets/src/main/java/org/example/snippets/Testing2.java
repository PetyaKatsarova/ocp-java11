package org.example.snippets;

public class Testing2 {
}

//public interface CanFly {
//    int fly();
//
//    String fly(int distance);
//}
//
//interface HasWings {
//    abstract String fly();
//
//    public abstract Object getWingSpan();
//}
//
//abstract class Falcon implements CanFly, HasWings {
//}

interface Jump {
    static public int MAX = 3;
}

abstract class Whale implements Jump {
    public abstract void dive();

    public static void main(String[] args) {
        Whale whale = new Orca();
//        whale.dive(3); //from the test: doesnt compile: Whale doesnt access the dive(int... i) override
        whale.dive();
    }
}

class Orca extends Whale {
    public void dive() {
        System.out.println("Orca diving");
    }

    public void dive(int... depth) {
        System.out.println("Orca diving deeper " + MAX);
    }
}