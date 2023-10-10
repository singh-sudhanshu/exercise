package io.java.exercise.binarytree;

/**
 * Binary three can have maximum of two children
 * Binary Search Trees are used in implementing the map and set ADTs
 * In Binary search tree the elements in left subtree is smaller than the elements in right subtree
 * Red Black tree
 * AVL tree
 * Binary trees are used in the implementation of binary heap
 * Operations like Insertion, Deletion, Search, remove takes O(log(n)) of time complexity
 * Worst case is O(n)
 */
public class BinaryTree {


    Node<Integer> node = new Node<>(5);

    class Node<T> {
        private final T val;
        private Node<T> left;
        private Node<T> right;

        public Node(T val) {
            this.val = val;
        }
    }
}


