package io.github.precodertech.codingjava;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class QueueUsingLinkedList {

    private LinkedList<Integer> queue = new LinkedList<>();

    public void enqueue(int value) {
        queue.addLast(value);
    }

    public int dequeue() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.removeFirst();
    }

}
