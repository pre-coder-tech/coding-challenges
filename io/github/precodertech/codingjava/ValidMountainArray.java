package io.github.precodertech.codingjava;

public class ValidMountainArray {

    public static void main(String[] args) {
        System.out.println(isValidMountainArray(new int[] {1,2,4,5,4,1}));
        System.out.println(isValidMountainArray(new int[] {2,1}));
        System.out.println(isValidMountainArray(new int[] {3,5,5}));
        System.out.println(isValidMountainArray(new int[] {0,2,3,3,5,2,1,0}));
    }

    /**
     * Given an array of integers arr, return true if and only if it is a valid
     * mountain array.
     *
     * Recall that arr is a mountain array if and only if:
     *
     * arr.length >= 3 There exists some i with 0 < i < arr.length - 1 such
     * that: arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
     * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
     *
     * Example 1:
     * Input: arr = [2,1] Output: false
     * Example 2:
     * Input: arr = [3,5,5] Output: false
     * Example 3:
     * Input: arr = [0,3,2,1] Output: true
     *
     *
     */

     static boolean isValidMountainArray(int[] intArr) {
        int peakNumber = 0;
        int peakIndex = 0;
        if (intArr.length < 3) return false;

        for (int i = 0; i< intArr.length; i++) {
            if (peakNumber < intArr[i]) { 
                peakNumber = intArr[i]; 
                peakIndex = i;
            }
        }
        
        for (int i = 0; i < peakIndex; i++) {
            if(intArr[i] >= intArr[i+1]) {
                return false;
            }
        }

        for (int i = peakIndex; i < intArr.length-1; i++) {
            if(intArr[i] <= intArr[i+1]) {
                return false;
            }
        }

        return !(peakIndex == intArr.length - 1 || peakIndex == 0);
     }
}
