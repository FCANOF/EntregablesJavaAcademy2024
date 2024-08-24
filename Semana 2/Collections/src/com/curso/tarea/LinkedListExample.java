package com.curso.tarea;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        // Create a LinkedList of strings
        List<String> animals = new LinkedList<>();

        // Add elements to the LinkedList
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Horse");
        animals.add("Elephant");

        // Display the LinkedList
        System.out.println("Animals: " + animals);

        // Add an element at a specific position
        animals.add(2, "Lion");

        // Display the LinkedList after adding an element at index 2
        System.out.println("Animals after adding Lion: " + animals);
    }
}
