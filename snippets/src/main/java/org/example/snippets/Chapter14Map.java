package org.example.snippets;

import java.util.HashMap;
import java.util.Map;

public class Chapter14Map {
    public static void main(String[] args) {
        Map m = new HashMap();
        m.put(123, "456");
        m.put("abc", "def");
        System.out.println(m.containsKey("123")); // MAP DOESNT HAVE CONTAINS BUT CONTAINSKEY, CONTAINSVALUE

        var map = new HashMap<Integer, Integer>();
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, null);
        map.merge(1, 3, (a,b) -> a + b);
        map.merge(3, 3, (a,b) -> a + b);
        System.out.println(map);
    }
}
