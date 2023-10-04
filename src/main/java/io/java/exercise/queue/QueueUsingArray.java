package io.java.exercise.queue;

import io.java.exercise.array.dynamic.DynamicArray;

import java.util.Iterator;

public class QueueUsingArray<E> implements Iterable {

    private final DynamicArray<E> list = new DynamicArray<>();

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
    }
}
