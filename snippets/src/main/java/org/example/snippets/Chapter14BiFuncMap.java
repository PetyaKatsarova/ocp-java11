package org.example.snippets;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Chapter14BiFuncMap {
    public static void main(String[] args) {
        BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;

        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", "Tram");
        String jenny = favorites.merge("Jenny", "Skyride", mapper);
        String tom = favorites.merge("Tom", "Skyride", mapper);

        System.out.println(favorites); // {Tom=Skyride, Jenny=Bus Tour}
        System.out.println(jenny);     // Bus Tour
        System.out.println(tom);       // Skyride

        BiFunction<String, String, String> mapper2 = (v1, v2) -> null;
        Map<String, String> favorites2 = new HashMap<>();
        favorites2.put("Jenny", "Bus Tour");
        favorites2.put("Tom", "Bus Tour");
        favorites2.merge("Jenny", "Skyride", mapper2); // deletes entry Jenny cause is set to null
        favorites2.merge("Sam", "Skyride", mapper2); // creates entyr Sam=Skyride
        System.out.println(favorites2);   // {Tom=Bus Tour, Sam=Skyride}
    }
}
