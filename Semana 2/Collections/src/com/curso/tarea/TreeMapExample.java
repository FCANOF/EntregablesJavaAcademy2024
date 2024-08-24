package com.curso.tarea;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        // Create a TreeMap of integers to strings
        Map<Integer, String> books = new TreeMap<>();

        // Add key-value pairs to the TreeMap
        books.put(102, "The Catcher in the Rye");
        books.put(103, "1984");

        // Display the TreeMap (will be sorted by keys)
        System.out.println("Books: " + books);

        // Access a value by its key
        String book = books.get(101);
        System.out.println("Book with ID 101: " + book);

        // Remove a key-value pair by key
        books.remove(102);

        // Display the TreeMap after removal (still sorted by keys)
        System.out.println("Books after removing ID 102: " + books);

        // Iterate over the TreeMap
        for (Map.Entry<Integer, String> entry : books.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Title: " + entry.getValue());
        }
    }
}

