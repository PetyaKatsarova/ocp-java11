package org.example.snippets;

public class ExceptionsQ1 {
    public static void main(String[] other) {
        Object obj = Integer.valueOf(3);
        String str = (String) obj;
        obj = null;
        System.out.println(obj.equals(null));
    }
}
