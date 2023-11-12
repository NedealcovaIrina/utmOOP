package org.utm.labfour;

import org.utm.labfour.Stack.ArrayStack;
import org.utm.labfour.Stack.DynamicArrayStack;
import org.utm.labfour.Stack.LinkedListStack;

public class Start {

    public static void main(String[] args) {
        System.out.println("Testing ArrayStack");
        ArrayStack<Integer> arrayStack = new ArrayStack<>();

        // Push elements onto the stack
        arrayStack.push(10);
        arrayStack.push(20);
        arrayStack.push(30);

        // Check if the stack is empty
        System.out.println("Is the stack empty? " + arrayStack.isEmpty());

        // Get the size of the stack
        System.out.println("Stack size: " + arrayStack.size());

        // Peek at the top element
        System.out.println("Peek at the top element: " + arrayStack.peek());

        // Pop elements from the stack
        while (!arrayStack.isEmpty()) {
            System.out.println("Popped: " + arrayStack.pop());
        }

        // Check if the stack is empty after popping
        System.out.println("Is the stack empty now? " + arrayStack.isEmpty());

        System.out.println("\nTesting LinkedListStack");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();

        // Push elements onto the stack
        linkedListStack.push(40);
        linkedListStack.push(50);
        linkedListStack.push(60);

        // Check if the stack is empty
        System.out.println("Is the stack empty? " + linkedListStack.isEmpty());

        // Get the size of the stack
        System.out.println("Stack size: " + linkedListStack.size());

        // Peek at the top element
        System.out.println("Peek at the top element: " + linkedListStack.peek());

        // Pop elements from the stack
        while (!linkedListStack.isEmpty()) {
            System.out.println("Popped: " + linkedListStack.pop());
        }

        // Check if the stack is empty after popping
        System.out.println("Is the stack empty now? " + linkedListStack.isEmpty());

        System.out.println("\nTesting DynamicArrayStack");

        DynamicArrayStack<Integer> dynamicArrayStack = new DynamicArrayStack<>();

        // Push elements onto the stack
        dynamicArrayStack.push(70);
        dynamicArrayStack.push(80);
        dynamicArrayStack.push(90);

        // Check if the stack is empty
        System.out.println("Is the stack empty? " + dynamicArrayStack.isEmpty());

        // Get the size of the stack
        System.out.println("Stack size: " + dynamicArrayStack.size());

        // Peek at the top element
        System.out.println("Peek at the top element: " + dynamicArrayStack.peek());

        // Pop elements from the stack
        while (!dynamicArrayStack.isEmpty()) {
            System.out.println("Popped: " + dynamicArrayStack.pop());
        }

        // Check if the stack is empty after popping
        System.out.println("Is the stack empty now? " + dynamicArrayStack.isEmpty());
    }
}
