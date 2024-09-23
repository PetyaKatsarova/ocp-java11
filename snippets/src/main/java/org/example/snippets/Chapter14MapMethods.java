package org.example.snippets;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class Chapter14MapMethods {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.clear(); // Removes all keys and values from the map.
        System.out.println("After clear: " + map); // {}

        map.put("A", 1);
        map.put("B", 2);
        System.out.println(map.containsKey("A")); // true if key "A" exists, false otherwise.
        System.out.println(map.containsValue(2)); // true if value 2 exists, false otherwise.

        Set<Map.Entry<String, Integer>> entries = map.entrySet(); // Returns a Set of key/value pairs.
        System.out.println("Entry set: " + entries); // [A=1, B=2]
        map.forEach((key, value) -> System.out.println(key + ": " + value));
        Integer valueA = map.get("A"); // Returns the value for key "A" or null if not found: 1
        System.out.println("Value of A: " + valueA); // 1
        Integer valueC = map.getOrDefault("C", 0); // Returns value for key "C" or default value 0 if not found.
        System.out.println("Value of C: " + valueC); // 0
        System.out.println(map.isEmpty()); // false if map has entries, true otherwise.
        Set<String> keys = map.keySet(); // Returns set of all keys.
        System.out.println("Keys: " + keys); // [A, B]

        // !!!!! NB !!!!!!!!!!!!!!
        map.merge("A", 5, Integer::sum); // Adds 5 to the value for key "A" (1 + 5 = 6).
        System.out.println("After merge: " + map.get("A")); // 6
        Integer oldValue = map.put("B", 3); // Adds or replaces key "B" and returns old value (2).
        System.out.println("Old value of B: " + oldValue); // 2
        System.out.println("New value of B: " + map.get("B")); // 3
        map.putIfAbsent("C", 7); // Adds key "C" if absent, returns null if added, or existing value otherwise.
        System.out.println("Value of C: " + map.get("C")); // 7
        Integer removedValue = map.remove("A"); // Removes key "A" and returns its value (6), or null if ot found.
        System.out.println("Removed value of A: " + removedValue); // 6
        map.replace("B", 8); // Replaces value of key "B" with 8 if it exists.
        System.out.println("Replaced value of B: " + map.get("B")); // 8
        map.replaceAll((key, value) -> value * 2); // Doubles each value in the map.
        System.out.println("After replaceAll: " + map); // {B=16, C=14}
        System.out.println("Size of the map: " + map.size()); // Returns number of entries in the map.
        Collection<Integer> values = map.values(); // Returns Collection of all values.
        System.out.println("Values: " + values); // [16, 14]
    }
//    public static void main(String[] args) {
//        Map<String, Integer> map = new HashMap<>();
//
//        // void clear()
//        map.put("A", 1);
//        map.clear(); // Clears the map
//
//        // boolean containsKey(Object key)
//        map.put("A", 1);
//        System.out.println(map.containsKey("A")); // true
//
//        // boolean containsValue(Object value)
//        System.out.println(map.containsValue(1)); // true
//
//        // Set<Map.Entry<K,V>> entrySet()
//        Set<Map.Entry<String, Integer>> entries = map.entrySet();
//        for (Map.Entry<String, Integer> entry : entries) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
//
//        // void forEach(BiConsumer(K key, V value))
//        map.forEach((key, value) -> System.out.println(key + ": " + value));
//
//        // V get(Object key)
//        System.out.println(map.get("A")); // 1
//
//        // V getOrDefault(Object key, V defaultValue)
//        System.out.println(map.getOrDefault("B", 0)); // 0
//
//        // boolean isEmpty()
//        System.out.println(map.isEmpty()); // false
//
//        // Set<K> keySet()
//        Set<String> keys = map.keySet();
//        System.out.println(keys); // [A]
//
//        // V merge(K key, V value, Function(<V, V, V> func))
//        map.merge("A", 10, Integer::sum); // Adds 10 to existing value
//        System.out.println(map.get("A")); // 11
//
//        // V put(K key, V value)
//        map.put("B", 2); // Adds or replaces a key/value pair
//
//        // V putIfAbsent(K key, V value)
//        map.putIfAbsent("C", 3); // Adds "C" if it's not already  [10,6]
//
//        // V remove(Object key)
//        map.remove("B"); // Removes key "B"
//
//        // V replace(K key, V value)
//        map.replace("A", 5); // Replaces value of key "A" with 5
//
//        // void replaceAll(BiFunction<K, V, V> func)
//        map.replaceAll((key, value) -> value * 2); // Doubles all values
//
//        // int size()
//        System.out.println(map.size()); // 2
//
//        // Collection<V> values()
//        System.out.println(map.values()); // [10, 6]
//    }

}


