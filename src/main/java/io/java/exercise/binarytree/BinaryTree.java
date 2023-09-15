package io.java.exercise.binarytree;

/**
 * Binary three can have maximum of two children
 */
public class BinaryTree {
    Node<Integer> node = new Node<>(5);
}

class Node<T> {
    private final T val;
    private Node<T> left;
    private Node<T> right;

    public Node(T val) {
        this.val = val;
    }
}
