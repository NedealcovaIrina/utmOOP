package org.utm.labfour;

import org.utm.labfour.Stack.ArrayStack;
import org.utm.labfour.Stack.LinkedListStack;
import org.utm.labfour.Stack.Stack;
import org.utm.labfour.Stack.StackUsingTwoQueues;
import org.utm.labfour.Queue.ArrayQueue;
import org.utm.labfour.Queue.LinkedListQueue;
import org.utm.labfour.Queue.Queue;
import org.utm.labfour.Queue.QueueUsingTwoStacks;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("What do you want?");
        System.out.println("1: Testing ArrayStack");
        System.out.println("2: Testing LinkedListStack");
        System.out.println("3: Testing StackUsingTwoQueues");
        System.out.println("4: Testing ArrayQueue");
        System.out.println("5: Testing LinkedListQueue");
        System.out.println("6: Testing QueueUsingTwoStacks");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                testStack(new ArrayStack<>());
                break;
            case 2:
                testStack(new LinkedListStack<>());
                break;
            case 3:
                testStack(new StackUsingTwoQueues<>());
                break;
            case 4:
                testQueue(new ArrayQueue<>());
                break;
            case 5:
                testQueue(new LinkedListQueue<>());
                break;
            case 6:
                testQueue(new QueueUsingTwoStacks<>());
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static void testStack(Stack<String> stack) {
        // Заполняем стек
        for (char ch = 'A'; ch <= 'E'; ch++) {
            stack.push(String.valueOf(ch));
        }

        System.out.println("Is the stack empty? " + stack.isEmpty());
        System.out.println("Peek at the top element: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Is the stack empty now? " + stack.isEmpty());
    }

    private static void testQueue(Queue<String> queue) {
        // Заполняем очередь
        for (int i = 1; i <= 5; i++) {
            queue.enqueue(String.valueOf(i));
        }

        System.out.println("Is the queue empty? " + queue.isEmpty());
        System.out.println("Peek at the first element: " + queue.peek());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Is the queue empty now? " + queue.isEmpty());
    }
}
