package com.curso.tarea;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Create a priority queue of integers
        Queue<Integer> queue = new PriorityQueue<>();

        // Add elements to the queue
        queue.add(30);
        queue.add(10);
        queue.add(20);

        // Display the queue (Note: order may not reflect priority)
        System.out.println("Queue: " + queue);

        // Poll the queue (retrieve and remove the head)
        int head = queue.poll();
        System.out.println("Head of queue: " + head);

        // Display the queue after polling
        System.out.println("Queue after polling: " + queue);

        // Iterate over the queue
        for (int number : queue) {
            System.out.println("Queue element: " + number);
        }
    }
}
