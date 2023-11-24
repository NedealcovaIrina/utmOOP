package org.utm.labfour.Stack;

import java.util.ArrayList;

public class ArrayStack<E> implements Stack<E> {
    private ArrayList<E> stack;

    public ArrayStack() {
        this.stack = new ArrayList<>();
    }

    @Override
    public void push(E element) {
        stack.add(element);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return stack.get(stack.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
