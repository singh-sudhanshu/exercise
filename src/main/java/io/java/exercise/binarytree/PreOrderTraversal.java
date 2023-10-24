package io.java.exercise.binarytree;

import java.util.Iterator;

public class PreOrderTraversal<T extends Comparable<T>> extends BinarySearchTree<T> implements Traversal<T> {

    @Override
    public Iterator<T> traverse(BinarySearchTree<Integer> binarySearchTree) {
        final int expectedNodeCount = binarySearchTree.size();
        final java.util.Stack<BinarySearchTree<T>.Node> stack = new java.util.Stack<>();
        stack.push((BinarySearchTree<T>.Node) binarySearchTree.getRoot());
        return new java.util.Iterator<>() {
            @Override
            public boolean hasNext() {
                if (expectedNodeCount != binarySearchTree.size()) {
                    throw new java.util.ConcurrentModificationException();
                }
                return binarySearchTree.getRoot() != null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if (expectedNodeCount != binarySearchTree.size()) {
                    throw new java.util.ConcurrentModificationException();
                }
                Node node = stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
                return node.val;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
