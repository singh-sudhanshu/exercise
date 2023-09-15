package io.java.exercise.sorting;

import java.util.Random;

// search kth smallest or largest value in an array
public class QuickSelect {

    private static int partition(int[] arr, int low, int high) {
        int pivotLocation = low;
        for (int i = low; i <= high; i++) {
            if (arr[i] < arr[high]) {
                int temp = arr[i];
                arr[i] = arr[pivotLocation];
                arr[pivotLocation] = temp;
                pivotLocation++;
            }
        }

        // Swap pivot with pivotLoc
        int temp = arr[high];
        arr[high] = arr[pivotLocation];
        arr[pivotLocation] = temp;
        return pivotLocation;
    }

    private static int findKthSmallestElement(int[] arr, int low, int high, int k) {
        if (k > arr.length) {
            System.out.println("Element not found");
        }
        int partitionKey = partition(arr, low, high);
        if (partitionKey == k - 1) {
            return arr[partitionKey];
        } else if (partitionKey < k - 1) {
            // search the right side of partitionKey
            return findKthSmallestElement(arr, partitionKey + 1, high, k);
        } else {
            return findKthSmallestElement(arr, low, partitionKey - 1, k);
        }
    }

    private static int findKthSmallestElement(int[] arr, int k) {
        return findKthSmallestElement(arr, 0, arr.length - 1, k);
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[10];
        for (int i =0; i <nums.length; i++) {
            nums[i] = random.nextInt(100);
        }
        print(nums);
        System.out.println("kth smallest element is: ");
        System.out.println(findKthSmallestElement(nums, 1));
    }
}
