package com.curso.tarea;
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // Create a map of integers to strings
        Map<Integer, String> map = new HashMap<>();

        // Add key-value pairs to the map
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        // Display the map
        System.out.println("Map: " + map);

        // Get a value by its key
        String value = map.get(2);
        System.out.println("Value for key 2: " + value);

        // Remove a key-value pair from the map
        map.remove(3);

        // Display the map after removal
        System.out.println("Map after removal: " + map);

        // Iterate over the map
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}

