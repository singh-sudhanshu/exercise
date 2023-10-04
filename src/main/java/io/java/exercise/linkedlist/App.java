package io.java.exercise.linkedlist;

public class App {

    public static void main(String[] args) {
        DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();
        linkedList.add("Sudhanshu");
        linkedList.add("Singh");
        var str = linkedList.toString();
        System.out.println(str);
        System.out.println(linkedList.size() + " is the size");
    }
}
