package coding_challenges_java;

import java.util.Arrays;

public class SplitArray {
    public static void main(String[] args) {
        splitArrayToChunks(new Object[] {1,45,8,3,78,3,2,6,8,2,4,4,2,2,6,7,36,34,56,3,3,65}, 5);
    }

    static void splitArrayToChunks(Object[] arr, int chunkSize) {
        int splitArraySize = arr.length % chunkSize == 0 ? arr.length / chunkSize : (arr.length / chunkSize) + 1;
        Object[][] chunkedArr = new Object[splitArraySize][];
        int index = 0;
        for (int i = 0; i < arr.length; i += chunkSize) {
            int currentChunkSize = Math.min(chunkSize, arr.length - i);
            Object[] tempObj = new Object[currentChunkSize];
            for (int j = 0; j < currentChunkSize; j++) {
                tempObj[j] = arr[i + j];
            }
            chunkedArr[index++] = tempObj;
        }
        System.out.println(Arrays.deepToString(chunkedArr));
    }
}
