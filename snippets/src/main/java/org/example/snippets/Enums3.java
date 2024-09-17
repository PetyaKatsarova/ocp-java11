package org.example.snippets;

public class Enums3 {
    enum Flavors {
        CHOCOLATE, STRAWBERRY, VANILLA
    }

//    public static void main(String[] args) {
//        Flavors STRAWBERRY = null;
//        switch (STRAWBERRY) {
//            case Flavors.VANILLA:
//                System.out.print("v");
//            case Flavors.CHOCOLATE:
//                System.out.print("c");
//            case Flavors.STRAWBERRY:
//                System.out.print("s");
//                break;
//            default:
//                System.out.println("missing flavor");
//        }
//    }

}

class Deer {
    enum Food {APPLES, BERRIES, GRASS}
    protected class Diet {
        private Food getFavorite() {
            return Food.BERRIES;
        }
    }
    public static void main(String[] seasons) {
        switch(new Deer().new Diet().getFavorite()) {
            case APPLES: System.out.print("a");
            case BERRIES: System.out.print("b");
            default: System.out.print("c");
        }
    }
}
