package io.java.exercise.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class FindKthLargestElement {

    public static Integer findKthLargestElement(List<Integer> data, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(data.get(i));
        }
        for (int i = k; i < data.size(); i++) {
            if (data.get(i) > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(data.get(i));
            }
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100));
        }
        int result = findKthLargestElement(list, 5);
        System.out.println(result);
    }
}
