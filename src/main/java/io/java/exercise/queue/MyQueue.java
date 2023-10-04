package io.java.exercise.queue;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @param <E>
 */
public class MyQueue<E> implements Iterable<E> {

    private final LinkedList<E> list = new LinkedList<>();

    public MyQueue() {

    }

    public MyQueue(E element) {
        offer(element);
    }

    private void offer(E element) {
        list.addLast(element);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return list.peekFirst();
    }

    public E poll() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return list.removeFirst();
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
