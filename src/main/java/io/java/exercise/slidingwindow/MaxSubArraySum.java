package io.java.exercise.slidingwindow;

/**
 * You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:
 * <p>
 * The length of the subarray is k, and
 * All the elements of the subarray are distinct.
 * Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */

public class MaxSubArraySum {

    public static int maximumSubArraySum(int[] nums, int k) {
        // basic check
        if (k == 0 || nums.length < k) {
            return 0;
        }
        // add every element to result until window size is reached
        int result = Integer.MIN_VALUE;
        int windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];
            // check if window size is reached after adding the element
            if (windowEnd - windowStart + 1 == k) { // When we hit the window size. Update maximum sum, and slide the window
                result = Math.max(result, windowSum);
                windowSum -= nums[windowStart];
                windowStart++; // slide the window
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 2, 9, 9, 9};
        System.out.println(maximumSubArraySum(nums, 3));
    }
}
