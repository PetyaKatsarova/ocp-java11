package org.example.snippets;

import java.util.LinkedList;
import java.util.Queue;

public class Chapter14LinkedList {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        System.out.println(queue.offer(10)); // true // adds el to the back
        System.out.println(queue.offer(4));  // true
        System.out.println(queue.peek());    // 10
        System.out.println(queue.poll());    // 10 //Removes and returns first el or null if the queue is empty.
        System.out.println(queue.poll());    // 4
        System.out.println(queue.peek());    // null
    }
}
