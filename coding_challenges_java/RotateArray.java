package coding_challenges_java;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        /* Write a program to rotate an array by a given number of positions. */
        int[] arr = new int[]{9, 6, 8, 5, 8};
        rotateArrayClockwise(arr, 2);
        System.err.println(Arrays.toString(arr));

        int[] arr1 = new int[]{-1, -100, 3, 99};
        rotateArrayClockwise(arr1, 2);
        System.err.println(Arrays.toString(arr1));

    }

    /**
     * Given an integer array nums, rotate the array to the right by k steps,
     * where k is non-negative. Example 1: Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4] Explanation: rotate 1 steps to the right:
     * [7,1,2,3,4,5,6] rotate 2 steps to the right: [6,7,1,2,3,4,5] rotate 3
     * steps to the right: [5,6,7,1,2,3,4]
     *
     * Example 2: Input: nums = [-1,-100,3,99], k = 2 Output: [3,99,-1,-100]
     * Explanation: rotate 1 steps to the right: [99,-1,-100,3] rotate 2 steps
     * to the right: [3,99,-1,-100]
     */
    static void rotateArrayClockwise(int[] arr, int k) {
        int current;
        int start = 0;
        int i = 0;

        while (i < arr.length) {
            current = start;
            int prevValue = arr[start];
            do {
                current = (current + k) % arr.length;
                int temp = arr[current];
                arr[current] = prevValue;
                prevValue = temp;
                i++;
            } while (current != start);
            start++;
        }
        /**
         * example 1: 
         * arr: {9,6,8,5,8}
         * current = null;
         * start = 0;
         * i = 0;
         * k = 2;
         * 
         * while start ->
         *   -> current = 0, prevValue = 9
         *      -> do_while start -> current = 2 -> arr = 9,6,9,5,8 -> prevValue = 8 -> i = 1
         *      -> do_while start -> current = 4 -> arr = 9,6,9,5,8 -> prevValue = 8 -> i = 2
         *      -> do_while start -> current = 1 -> arr = 9,8,9,5,8 -> prevValue = 6 -> i = 3
         *      -> do_while start -> current = 3 -> arr = 9,8,9,6,8 -> prevValue = 5 -> i = 4
         *      -> do_while start -> current = 0 -> arr = 5,8,9,6,8 -> prevValue = 9 -> i = 5
         *      -> do_while exit
         *   -> start = 1
         *   -> while exit
         * 
         * example 2:
         * arr: {-1,-100,3,99}
         * current = null;
         * start = 0;
         * i = 0;
         * k = 2;
         * 
         * while start ->
         *   -> current = 0, prevValue = -1
         *      -> do_while start -> current = 2 -> arr = -1,-100,-1,99 -> prevValue = 3 -> i = 1
         *      -> do_while start -> current = 0 -> arr = 3,-100,-1,99 -> prevValue = -1 -> i = 2
         *      -> do_while exit
         *   -> start = 1
         *   -> current = 1, prevValue = -100
         *      -> do_while start -> current = 3 -> arr = 3,-100,-1,-100 -> prevValue = 99 -> i = 3
         *      -> do_while start -> current = 1 -> arr = 3,99,-1,-100 -> prevValue = -100 -> i = 4
         *      -> do_while exit
         *   -> start = 2
         *   -> while exit
         * 
         */
    }
}
