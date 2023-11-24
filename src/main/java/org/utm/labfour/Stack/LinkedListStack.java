package org.utm.labfour.Stack;

import java.util.LinkedList;

public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> stack;

    public LinkedListStack() {
        this.stack = new LinkedList<>();
    }

    @Override
    public void push(E element) {
        stack.addFirst(element);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return stack.removeFirst();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return stack.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
