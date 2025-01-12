package io.github.precodertech.codingjava;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

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

        /**
         * Remove Duplicates from Sorted Array
         *
         * Given an integer array nums sorted in non-decreasing order, remove
         * the duplicates in-place such that each unique element appears only
         * once. The relative order of the elements should be kept the same.
         * Then return the number of unique elements in nums.
         *
         * Consider the number of unique elements of nums to be k, to get
         * accepted, you need to do the following things:
         *
         * Change the array nums such that the first k elements of nums contain
         * the unique elements in the order they were present in nums initially.
         * The remaining elements of nums are not important as well as the size
         * of nums. Return k.
         */
        int[] nums = {1, 1, 2}; // Input array
        int[] expectedNums = {1, 2}; // The expected answer with correct length
        System.out.print("nums: " + Arrays.toString(nums));

        int k = removeDuplicates(nums); // Calls your implementation

        System.out.println(" || k: " + k + " || expectedNums: " + Arrays.toString(expectedNums));

        /**
         * Remove Element
         *
         * Given an integer array nums and an integer val, remove all
         * occurrences of val in nums in-place. The order of the elements may be
         * changed. Then return the number of elements in nums which are not
         * equal to val.
         *
         * Consider the number of elements in nums which are not equal to val
         * be k, to get accepted, you need to do the following things:
         *
         * Change the array nums such that the first k elements of nums
         * contain the elements which are not equal to val. The remaining
         * elements of nums are not important as well as the size of nums.
         * Return k.
         */
        int[] nums1 = {3,2,2,3}; // Input array
        int[] expectedNums1 = {2,2}; // The expected answer with correct length
        System.out.print("nums: " + Arrays.toString(nums1));
        
        int l = removeElement(nums1, 3); // Calls your implementation

        System.out.println(" || l: " + l + " || expectedNums: " + Arrays.toString(expectedNums1));
    }

    static int removeElement(int[] nums, int val) {
        int index = 0;
        int reIndex = 0;
        for (; index < nums.length; index++) {
            if (nums[index] != val) {
               nums[reIndex++] = nums[index];
            }
        }
        return reIndex;
    }

    static int removeDuplicates(int[] nums) {
        Set<Integer> uniqueElements = new TreeSet<>();
        int index;
        for (index = 0; index < nums.length; index++) {
            uniqueElements.add(nums[index]);
        }
        index = 0;
        for (Integer num : uniqueElements) {
            nums[index++] = num;
        }
        return uniqueElements.size();
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
