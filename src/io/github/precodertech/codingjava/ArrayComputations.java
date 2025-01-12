package io.github.precodertech.codingjava;

import java.util.Arrays;

public class ArrayComputations {

    public static void main(String[] args) {
        /**
         * program to increment last digit in an array
         */
        int[] arr = new int[]{1, 2, 4, 8, 20, 6, 9, 24, 7, 3, 7, 2, 457, 5, 234};
        increamentLastDigit(arr, 2);
        System.out.println(Arrays.toString(arr));

        /**
         * Remove One Element to Make the Array Strictly Increasing
         *
         * Given a 0-indexed integer array nums, return true if it can be made
         * strictly increasing after removing exactly one element, or false
         * otherwise. If the array is already strictly increasing, return true.
         *
         * The array nums is strictly increasing if nums[i - 1] < nums[i] for
         * each index (1 <= i < nums.length).
         */
        System.out.println(canBeIncreasing(new int[]{1, 2, 10, 5, 7}));
        System.out.println(canBeIncreasing(new int[]{2, 3, 1, 2}));
        System.out.println(canBeIncreasing(new int[]{1, 1, 1}));

    }

    static boolean canBeIncreasing(int[] nums) {
        int count = 0; // Count of violations
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) { // Violation found
                count++;
                // If more than one violation, return false
                if (count > 1) {
                    return false;
                }
                // Check if removing nums[i - 1] or nums[i] fixes the issue
                if (i > 1 && nums[i] <= nums[i - 2] && i < nums.length - 1 && nums[i + 1] <= nums[i - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void increamentLastDigit(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + k;
        }
    }
}
