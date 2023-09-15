package io.java.exercise.sorting;

/**
 * QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array around the picked pivot.
 * There are many different versions of quickSort that pick pivot in different ways.
 * Always pick first element as pivot.
 * Always pick last element as pivot (implemented below)
 * Pick a random element as pivot.
 * Pick median as pivot.
 */
public class QuickSort {


    // Get a pivot point and everything smaller than pivot point goes to left and bigger goes to right
    // Divide and Conquer: Recursively, sort two subarrays with Quicksort.
    // Worst Case Complexity - In quick sort, worst case occurs when the pivot element is either greatest or smallest element.
    // Suppose, if the pivot element is always the last element of the array, the worst case would occur when the given array is sorted already in ascending or descending order. The worst-case time complexity of quicksort is O(n2).

    // Divide
    private static int partition(int[] arr, int low, int high) {
//        int pivot = data[end];
//        int i = start - 1; //smallest element in the data
//        for (int j = start; j <= end - 1; j++) {
//            // if current element is less than pivot then increment i
//            if (data[j] < pivot) {
//                i++;
//                swap(data, i, j);
//            }
//        }
//        swap(data, i + 1, end);
//        return (i + 1);

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

    //Conquer
    private static void quickSort(int[] data, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(data, start, end);
            quickSort(data, start, partitionIndex - 1);
            quickSort(data, partitionIndex + 1, end);
        }
    }

    public static void quickSort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }

    private static void swap(int[] data, int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    public static void print(int[] data) {
        for (int i : data) {
            System.out.println(i);
        }
    }
}
