package io.github.precodertech.codingjava;

import java.util.Arrays;

public class ArrayComputations {
    public static void main(String[] args) {
        /** program to increment last digit in an array */
        int[] arr = new int[] {1,2,4,8,20,6,9,24,7,3,7,2,457,5,234};
        increamentLastDigit(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

    static void increamentLastDigit(int[] arr, int k) {
        for(int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + k;
        }
    }
}
