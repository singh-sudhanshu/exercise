package io.java.exercise.linkedlist;

import java.util.Iterator;

public class DoublyLinkedList<E> implements Iterable<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(E element) {
        addLast(element);
    }

    private void addLast(E element) {
        if (isEmpty()) {
            head = tail = new Node<>(element, null, null);
        } else {
            tail.next = new Node<>(element, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public void addFirst(E data) {
        if (isEmpty()) {
            head = tail = new Node<>(data, null, null);
        } else {
            head.prev = new Node<>(data, null, head);
            head = head.prev;
        }
        size++;
    }

    public E peekFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        return head.data;
    }

    public E peekLast() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        return tail.data;
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        var data = head.data;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        head.prev = null;
        return data;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        var data = tail.data;
        tail = tail.prev;
        size--;
        if (isEmpty()) {
            head = null;
        }
        tail.next = null;
        return data;
    }

    //Removes as arbitrary node
    private E remove(Node<E> node) {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        node.next.prev = node.next;
        node.prev.next = node.prev;

        //Temp store to return
        var data = node.data;
        // clear memory
        node.data = null;
        node = node.next = node.prev = null;
        size--;
        return data;
    }

    public E removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("Invalid index");
        }
        int i;
        Node<E> trav;
        if (index < size / 2) {
            for (i = 0, trav = head; i != index; i++) {
                trav = trav.next;
            }
        } else {
            for (i = size - 1, trav = tail; i != index; i--) {
                trav = tail.prev;
            }
        }
        return remove(trav);
    }

    public boolean remove(Object obj) {
        Node<E> trav;
        for (trav = head; trav.next != null; trav = trav.next) {
            if (trav.data == null) {
                remove(trav);
                return true;
            } else {
                for (trav = head; trav.next != null; trav = trav.next) {
                    if (trav.data.equals(obj)) {
                        remove(trav);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int indexOf(Object obj) {
        int index = 0;
        Node<E> trav;
        if (obj == null) {
            for (trav = head; trav != null; trav = trav.next, index++) {
                if (trav.data == null) {
                    return index;
                }
            }
        } else {
            for (trav = head; trav != null; trav = trav.next, index++) {
                if (trav.data.equals(obj)) {
                    return index;
                }
            }
        }
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public void clear() {
        // Any operation in list starts from head using a trav pointer
        var trav = head;
        while (trav != null) {
            // holding reference of next to move forward
            var next = trav.next;
            trav.prev = null;
            trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node<E> trav = head;

            @Override
            public boolean hasNext() {
                return trav.next != null;
            }

            @Override
            public E next() {
                E data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        var trav = head;
        while (trav != null) {
            stringBuilder.append(trav.data).append(", ");
            trav = trav.next;
        }
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }
}

class Node<T> {
    T data;
    Node<T> prev;
    Node<T> next;

    public Node(T data, Node<T> prev, Node<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
