package io.java.exercise.binarytree;

import java.util.Iterator;

public interface Traversal<T> {
    Iterator<T> traverse(BinarySearchTree<Integer> binarySearchTree);
}
