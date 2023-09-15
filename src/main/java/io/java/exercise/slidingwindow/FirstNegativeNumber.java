package io.java.exercise.slidingwindow;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeNumber {

    public static void main(String[] args) {
        int[] a = {10, -1, -5, 7, -15, 20, 18, 24};
        int k = 3;

        printFirstNegativeNumber(a, k);
    }

    private static void printFirstNegativeNumber(int[] a, int k) {
        if (k == 0 || a.length < k) {
            System.out.println(0);
        }
        int windowStart = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int windowEnd = 0; windowEnd < a.length; windowEnd++) {
            if (a[windowEnd] < 0) {
                queue.add(a[windowEnd]);
            }
            if (windowEnd - windowStart + 1 == k) { // window is full
                // run the business logic here
                if (queue.isEmpty()) {
                    System.out.println(0);
                } else {
                    int num = queue.peek();
                    System.out.println(num);
                    if (num == a[windowStart]) {
                        queue.remove();
                    }
                }
                windowStart++; // slide the window
            }
        }
    }
}
