package io.java.exercise.binarytree;

import java.util.Iterator;

/**
 * Binary three can have maximum of two children
 * Binary Search Trees are used in implementing the map and set ADTs
 * In Binary search tree the elements in left subtree is smaller than the elements in right subtree
 * Red Black tree
 * AVL tree
 * Binary trees are used in the implementation of binary heap
 * Operations like Insertion, Deletion, Search, remove takes O(log(n)) of time complexity
 * Worst case is O(n)
 * Elements inside the BST should be comparable so we can order them inside the tree.
 * Building a BST from a sorted elements will result O(n)
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private int nodeCount;
    private Node root;

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return nodeCount;
    }

    public boolean add(T element) {
        if (contains(element)) {
            return false;
        } else {
            root = add(root, element);
            nodeCount++;
            return true;
        }
    }

    public boolean remove(T element) {
        if (contains(element)) {
            root = remove(root, element);
            nodeCount--;
            return true;
        }
        return false;
    }

    private Node remove(Node node, T element) {
        // Base case. Found leaf node
        if (node == null) {
            return null;
        }
        int compare = element.compareTo(node.val);
        if (compare < 0) {
            node.left = remove(node.left, element);
        } else if (compare > 0) {
            node.right = remove(node.right, element);
        } // found the node to be removed
        else {
            // tree with only right subtree. In this case just swap the element we wish to remove with right child
            if (node.left == null) {
                var rightNode = node.right;
                node.val = null;
                node = null;
                return rightNode;
            }
            // tree with only left subtree. In this case just swap the element we wish to remove with left child
            else if (node.right == null) {
                var leftNode = node.left;
                node.val = null;
                node = null;
                return leftNode;
            }
            // When removing the node from BST with two links, the successor of the node being removed can
            // either be the largest value from left subtree or the smallest value from the right subtree.
            // In this implementation, we have decided to find the smallest value from right subtree by traversing
            // as left as possible in right subtree
            else {
                // Finding the smallest element in right subtree
                Node successor = digLeft(node.right);
                // Swap the node
                node.val = successor.val;
                // Go into the right subtree and remove the node we found and swap the data with. This will prevent us
                // having two nodes with same value.
                node.right = remove(node.right, successor.val);
            }
        }
        return node;
    }

    private Node digLeft(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private Node add(Node node, T element) {
        // Base case. Found leaf node
        if (node == null) {
            node = new Node(element, null, null);
        } else {
            if (element.compareTo(node.val) < 0) {
                node.left = add(node.left, element);
            } else {
                node.right = add(node.right, element);
            }
        }
        return node;
    }

    private boolean contains(T element) {
        return contains(root, element);
    }

    private boolean contains(Node node, T element) {
        // Base case: Value not found
        if (node == null) {
            return false;
        }
        int compare = element.compareTo(node.val);
        // Search in left subtree because the value we are looking for is smaller than the current value
        if (compare < 0) {
            return contains(node.left, element);
        } else if (compare > 0) {
            return contains(node.right, element);
        }
        // found the value
        else {
            return true;
        }
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        // Every time we recurse, increment the value by 1 which is the depth of the tree
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public Iterator<T> traverse(Traversal<T> traversalOrder, BinarySearchTree<Integer> binarySearchTree) {
        return traversalOrder.traverse(binarySearchTree);
    }

    public Node getRoot() {
        return root;
    }

    public class Node {
        T val;
        Node left;
        Node right;

        public Node(T val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


