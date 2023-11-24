package org.utm.labfour.Queue;


import org.utm.labfour.Stack.LinkedListStack;
import org.utm.labfour.Stack.Stack;

public class QueueUsingTwoStacks<E> implements Queue<E> {
    private Stack<E> stack1;
    private Stack<E> stack2;

    public QueueUsingTwoStacks() {
        this.stack1 = new LinkedListStack<>();
        this.stack2 = new LinkedListStack<>();
    }

    @Override
    public void enqueue(E element) {
        stack1.push(element);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    @Override
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

