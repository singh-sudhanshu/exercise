package io.java.exercise.stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Stacks can be implemented using arrays and singly linked list
 * Used for DFS
 * It can be implemented using arrays, singly linked list or doubly linked list
 *
 * @param <E>
 */
public class MyStack<E> implements Iterable<E> {

    private final LinkedList<E> list = new LinkedList<>();

    public MyStack() {
    }

    public MyStack(E element) {
        push(element);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E element) {
        list.addLast(element);
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.removeLast();
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.peekLast();
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
