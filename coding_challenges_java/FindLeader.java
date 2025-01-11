package coding_challenges_java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FindLeader {

    public static void main(String[] args) {
        List<Integer> leadersTraditionalWay = findLeaderTraditionalWay(new int[]{16, 17, 4, 3, 5, 2, 7});
        System.out.println(leadersTraditionalWay.toString());
        List<Integer> leadersFunctionalWay = findLeaderFunctionalWay(new int[]{16, 17, 4, 3, 5, 2, 7});
        System.out.println(leadersFunctionalWay.toString());
    }

    /**
     * Given an array arr[] of size n, the task is to find all the Leaders in
     * the array. An element is a Leader if it is greater than or equal to all
     * the elements to its right side.
     *
     * Note: The rightmost element is always a leader.
     *
     * Examples: Input: arr[] = [16, 17, 4, 3, 5, 2] Output: [17 5 2]
     *
     * Explanation: 17 is greater than all the elements to its right i.e., [4,
     * 3, 5, 2], therefore 17 is a leader. 5 is greater than all the elements to
     * its right i.e., [2], therefore 5 is a leader. 2 has no element to its
     * right, therefore 2 is a leader.
     */
    static List<Integer> findLeaderTraditionalWay(int[] numbers) {
        List<Integer> leaders = new ArrayList<> ();
        boolean leader;
        for (int i = 0; i < numbers.length; i++) {
            leader = true;
            for (int j = i + 1; j < numbers.length; j++) {
                leader &= (numbers[i] > numbers[j]);
            }
            if (leader) {
               leaders.add(numbers[i]);
            }
        }
        return leaders;
    }

    static List<Integer> findLeaderFunctionalWay(int[] numbers) {
        List<Integer> leaders = new ArrayList<>();
        IntStream.range(0, numbers.length).forEach(i -> {
            if(IntStream.range(i+1, numbers.length).allMatch(j -> numbers[i] > numbers[j])) {
                leaders.add(numbers[i]);
            }
        });
        return leaders;
    }
}
