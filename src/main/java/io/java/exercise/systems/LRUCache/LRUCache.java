package io.java.exercise.systems.LRUCache;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class LRUCache<T> {

    private Integer size;
    private final Integer capacity;
    private final Map<String, Node> map;
    private final DoublyLinkedList queue;

    public LRUCache(Integer capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.queue = new DoublyLinkedList();
        this.size = 0;
    }

    public T get(String key) {
        Node node = map.get(key);
        if (node == null) {
            return null;
        }
        // Element has been accessed. Hence, sending it to front of the queue
        queue.moveNodeToFront(node);
        return map.get(key).val;
    }

    public void put(String key, T value) {
        // Check if the key is already there
        Node currentNode = map.get(key);
        if (currentNode != null) {
            currentNode.val = value;
            queue.moveNodeToFront(currentNode);
        }
        // check if there is space in the cache, if not then remove the element from the rear
        if (Objects.equals(size, capacity)) {
            String rearKey = queue.keyOfRearNode();
            queue.removeNodeFromRear();
            // remove from map as well.
            System.out.println("key to be removed: " + rearKey);
            map.remove(rearKey);
            size--;
        }
        Node node = new Node(key, value);
        queue.addNodeToFront(node);
        map.put(key, node);
        size++;
    }

    private class Node {
        private final String key;
        private T val;
        private Node next, prev;

        public Node(String key, T val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    private class DoublyLinkedList {
        private Node front, rear;

        public DoublyLinkedList() {
            front = rear = null;
        }

        private void addNodeToFront(Node node) {
            if (rear == null) {
                front = rear = node;
                return;
            }
            node.next = front;
            front.prev = node;
            front = node;
        }

        private void moveNodeToFront(Node node) {
            if (front == node) {
                return;
            }
            if (node == rear) {
                rear = rear.prev;
                rear.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            node.prev = null;
            node.next = front;
            front.prev = node;
            front = node;
        }

        private void removeNodeFromRear() {
            //queue is empty
            if (rear == null) {
                return;
            }
            if (front == rear) {
                //only one node in queue
                front = rear = null;
            } else {
                //More than one element is in the queue
                rear = rear.prev;
                rear.next = null;
            }
        }

        private String keyOfRearNode() {
            return rear.key;
        }
    }
}
