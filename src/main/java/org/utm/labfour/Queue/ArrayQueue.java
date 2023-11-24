package org.utm.labfour.Queue;

import java.util.ArrayList;

public class ArrayQueue<E> implements Queue<E> {
    private ArrayList<E> queue;

    public ArrayQueue() {
        this.queue = new ArrayList<>();
    }

    @Override
    public void enqueue(E element) {
        queue.add(element);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        return queue.remove(0);
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return queue.get(0);
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

