
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class NumberAggregations {

    public static void main(String[] args) {
        System.out.println(sumOfThreeLargestNumber(new int[]{3, 35, 20, 2, 1}));
        System.out.println(sumOfThreeLargestNumber(Arrays.asList(3, 35, 20, 2, 1)));
        System.out.println(sumOfSquaresOfOddNumbers(Arrays.asList(1, 3, 2, 5, 7, 2)));
    }

    static long sumOfSquaresOfOddNumbers(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 != 0).map(n -> n * 2).mapToInt(Integer::intValue).sum();
    }

    static long sumOfThreeLargestNumber(List<Integer> numbers) {
        return numbers.stream().sorted(Collections.reverseOrder()).limit(3).reduce(0, Integer::sum);
    }

    static long sumOfThreeLargestNumber(int[] numbers) {
        return IntStream.of(numbers)
                .boxed()
                .sorted(Collections.reverseOrder())
                .limit(3)
                .mapToInt(Integer::intValue)
                .sum();

    }
}
