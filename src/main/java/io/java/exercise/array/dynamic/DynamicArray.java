package io.java.exercise.array.dynamic;

import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T> {

    private T[] elements;
    private int length;
    private int capacity;

    public DynamicArray() {
        this(16);
    }

    public DynamicArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal capacity: " + capacity);
        }
        this.capacity = capacity;
        elements = (T[]) new Object[capacity];
    }

    public int size() {
        return this.length;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public T get(int index) {
        return elements[index];
    }

    public void set(int index, T element) {
        elements[index] = element;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            elements[i] = null;
            length = 0;
        }
    }

    public void add(T element) {
        // if there is enough space. If yes then add else create a new array with double the size then copy and add
        if (length + 1 >= capacity) {
            capacity *= 2;
            T[] temp = (T[]) new Object[capacity];
            if (length >= 0) {
                System.arraycopy(elements, 0, temp, 0, length);
            }
            elements = temp;
        }
        elements[length++] = element;
    }

    public T removeAt(int index) {
        // check valid index
        T data = elements[index];
        T[] temp = (T[]) new Object[length - 1];
        for (int i = 0, j = 0; i < length; i++, j++) {
            if (i == index) {
                j--; // skipping the remove index
            } else {
                temp[j] = elements[i];
            }
        }
        elements = temp;
        capacity = --length;
        return data;
    }

    public boolean remove(T element) {
        // first need to find the element to remove
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(element)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(T element) {
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    public void print() {
        for (T element : elements) {
            System.out.println("[ " + element + "] ");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public T next() {
                return elements[index++];
            }
        };
    }
}
