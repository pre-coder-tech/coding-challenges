package coding_challenges_java;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class PrintNumbers {

    public static void main(String[] args) {
        printReverseTriangle(10);
        printPairOfNumbersWithDiff(new int[]{345, 3456, 23, 567, 21, 456, 43, 23, 7, 31, 37, 49, 786, 30, 34, 67, 2223, 56,}, 5);
    }

    static void printReverseTriangle(int maxNumber) {
        IntStream.iterate(maxNumber, i -> i - 1).limit(maxNumber).forEach(i -> {
            IntStream.iterate(maxNumber, j -> j - 1).limit((maxNumber - i) + 1).forEach(j -> System.out.print(j + " "));
            System.out.println();
        });

        for (int i = maxNumber; i > 0; i--) {
            for (int j = maxNumber; j >= i; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void printPairOfNumbersWithDiff(int[] numbers, int difference) {
        int startIndex = 0;
        int backwardIndex = numbers.length - 1;

        List<Integer> numbersList = IntStream.of(numbers).boxed().sorted(Collections.reverseOrder()).toList();
        System.out.println(numbersList);
        int calculatedDiff;
        while (startIndex != backwardIndex) {
            calculatedDiff = numbersList.get(startIndex) - numbersList.get(backwardIndex);
            if (calculatedDiff == difference) {
                System.out.println("Pair is: " + numbersList.get(startIndex) + "  " + numbersList.get(backwardIndex));
                break;
            } else if (calculatedDiff > difference) {
                startIndex++;
            } else {
                backwardIndex--;
                startIndex = 0;
            }
            if (startIndex == backwardIndex) {
                backwardIndex--;
                startIndex = 0;
            }
        }
    }
}
