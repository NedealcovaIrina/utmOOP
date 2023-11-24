package org.utm.labfour.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues<E> implements Stack<E> {
    private Queue<E> queue1;
    private Queue<E> queue2;

    public StackUsingTwoQueues() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    @Override
    public void push(E element) {
        queue2.add(element);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }
        Queue<E> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return queue1.remove();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return queue1.peek();
    }

    @Override
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}
