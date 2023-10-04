package io.java.exercise.array.dynamic;

public class App {
    public static void main(String[] args) {
        DynamicArray<String> list = new DynamicArray<>(3);
        list.add("Sudhanshu");
        list.add("Singh");
        list.remove("Sudhanshu");
        list.print();
    }
}
