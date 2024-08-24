package com.curso.tarea;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        // Create a TreeSet of strings
        Set<String> fruits = new TreeSet<>();

        // Add elements to the TreeSet
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        // Display the TreeSet (will be in natural order)
        System.out.println("Fruits: " + fruits);

        // Remove an element from the TreeSet
        fruits.remove("Banana");

        // Display the TreeSet after removal
        System.out.println("Fruits after removal: " + fruits);

        // Iterate over the TreeSet
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }
    }
}