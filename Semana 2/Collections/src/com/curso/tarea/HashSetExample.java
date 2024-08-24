package com.curso.tarea;
import java.util.HashMap;
import java.util.Map;

public class HashSetExample {
    public static void main(String[] args) {
        // Create a HashMap of integers to strings
        Map<Integer, String> students = new HashMap<>();

        // Add key-value pairs to the HashMap
        students.put(1, "Alice");
        students.put(2, "Bob");
        students.put(3, "Charlie");

        // Display the HashMap
        System.out.println("Students: " + students);

        // Access a value by its key
        String student = students.get(2);
        System.out.println("Student with ID 2: " + student);

        // Remove a key-value pair by key
        students.remove(3);

        // Display the HashMap after removal
        System.out.println("Students after removing ID 3: " + students);

        // Iterate over the HashMap
        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue());
        }
    }
}
