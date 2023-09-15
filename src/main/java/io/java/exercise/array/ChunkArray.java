package io.java.exercise.array;

/*
 * Given an array and chunk size, divide the array into sub arrays each will be the length of chunk size.
 * */

import java.util.ArrayList;
import java.util.Objects;

public class ChunkArray {

    public static void main(String[] args) {
        var result = chunkArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3);
        System.out.println(result);
    }

    public static ArrayList<ArrayList<Integer>> chunkArray(int[] collection, int chunkSize) {
        if (Objects.isNull(collection) || chunkSize <= 0) {
            return null;
        }
        var chunked = new ArrayList<ArrayList<Integer>>();
        var chunk = new ArrayList<Integer>();

        for (int j : collection) {
            chunk.add(j);
            // need to check if chunk is full. If full then push it to chunked and create a new chunk
            if (chunk.size() == chunkSize) {
                chunked.add(chunk);
                chunk = new ArrayList<>();
            }
        }
        // edge case where collection is left with the less number of elements than the chunkSize
        if (!chunk.isEmpty()) {
            chunked.add(chunk);
        }
        return chunked;
    }
}
