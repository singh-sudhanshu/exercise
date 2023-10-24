package io.java.exercise.binarytree;

import java.util.Iterator;

public class Client {

    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(5);
        binarySearchTree.add(8);
        binarySearchTree.add(4);
        binarySearchTree.add(99);
        binarySearchTree.add(45);
        binarySearchTree.remove(45);
        System.out.println(binarySearchTree.height());
        Iterator<Integer> iterator = binarySearchTree.traverse(new LevelOrderTraversal<>(), binarySearchTree);
        while (iterator.hasNext()) {
            System.out.println("BFS traversal is: " + iterator.next());
        }
    }
}
