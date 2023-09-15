package io.java.exercise.sorting;

import java.util.Random;

public class App {

    public static void main(String[] args) {
        Random random = new Random();
        int[] data = new int[10];
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(100);
        }
        System.out.println("Before sorting");
        QuickSort.print(data);
        QuickSort.quickSort(data);
        System.out.println("After sorting");
        QuickSort.print(data);
    }
}
