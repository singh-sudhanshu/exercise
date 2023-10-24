package io.java.exercise.binarytree;

import java.util.Iterator;

public class PostOrderTraversal<T extends Comparable<T>> extends BinarySearchTree<T> implements Traversal<T> {

    @Override
    public Iterator<T> traverse(BinarySearchTree<Integer> binarySearchTree) {
        final int expectedNodeCount = binarySearchTree.size();
        final Node root = (BinarySearchTree<T>.Node) binarySearchTree.getRoot();
        final java.util.Stack<Node> stack1 = new java.util.Stack<>();
        final java.util.Stack<Node> stack2 = new java.util.Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            if (node != null) {
                stack2.push(node);
                if (node.left != null) stack1.push(node.left);
                if (node.right != null) stack1.push(node.right);
            }
        }
        return new java.util.Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (expectedNodeCount != binarySearchTree.size()) throw new java.util.ConcurrentModificationException();
                return root != null && !stack2.isEmpty();
            }

            @Override
            public T next() {
                if (expectedNodeCount != binarySearchTree.size()) throw new java.util.ConcurrentModificationException();
                return stack2.pop().val;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
