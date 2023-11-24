package org.utm.labfour.Queue;

import java.util.LinkedList;

public class LinkedListQueue<E> implements Queue<E> {
    private LinkedList<E> queue;

    public LinkedListQueue() {
        this.queue = new LinkedList<>();
    }

    @Override
    public void enqueue(E element) {
        queue.addLast(element);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        return queue.removeFirst();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return queue.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
