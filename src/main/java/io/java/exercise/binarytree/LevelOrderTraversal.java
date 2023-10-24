package io.java.exercise.binarytree;

import java.util.Iterator;

/**
 * It implements BFS using queue
 *
 * @param <T>
 */
public class LevelOrderTraversal<T extends Comparable<T>> extends BinarySearchTree<T> implements Traversal<T> {

    @Override
    public Iterator<T> traverse(BinarySearchTree<Integer> binarySearchTree) {
        final int expectedNodeCount = binarySearchTree.size();
        final Node root = (BinarySearchTree<T>.Node) binarySearchTree.getRoot();
        final java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.offer(root);

        return new java.util.Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (expectedNodeCount != binarySearchTree.size()) throw new java.util.ConcurrentModificationException();
                return root != null && !queue.isEmpty();
            }

            @Override
            public T next() {
                if (expectedNodeCount != binarySearchTree.size()) throw new java.util.ConcurrentModificationException();
                Node node = queue.poll();
                assert node != null;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                return node.val;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
