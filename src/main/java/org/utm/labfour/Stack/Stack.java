package org.utm.labfour.Stack;
public interface Stack<E> {
    void push(E element);
    E pop();
    E peek();
    boolean isEmpty();
    //int size();
}
