
import java.util.stream.IntStream;

public class CompetativeProgramming {

    public static void main(String[] args) {

        /* 
        N people live in a town. The houses are arranged in a row. 
        The personality of each owner is represented by a lowercase English character. 
        Each person is in a fight with all those people who have a mirror personality to the one in the fight.

        'a' is a mirror of 'z' and vice versa
        'b' is a mirror of 'y' and vice versa
        and so  
         */
        System.out.println(solution("wjlahohpec"));
        System.out.println(solution("aaz"));
        System.out.println(solution("wjlspxbyclapec"));

        /*
        *  Find the minimum cost of traveling between two tram stations in a circular city with N stations numbered from 1 to N. 
        * The cost of tickets between adjacent stations is given in an array ticket_cost, where ticket_cost[i] represents 
        * the cost of traveling from station i to station (i + 1) % N. Trams can move in both clockwise and anti-clockwise directions. 
        * The input includes N, the start station, and the finish station. 
        * 
        * The output should be the minimum cost of traveling from start to finish station.
        * 
        * 
         */
        System.out.println(solve(5, 4, 3, new int[]{12, 6, 2, 6, 2}));
        System.out.println(solve(4, 1, 3, new int[]{1, 2, 3, 4}));
    }

    static int solution(String people) {
        char[] peopleArray = people.toCharArray();
        int[] countPeople = new int[26];

        IntStream.range(0, peopleArray.length).forEach(i -> countPeople[peopleArray[i] - 'a']++);
        return Math.floorDiv(
                IntStream.range(0, peopleArray.length)
                        .map(i -> countPeople['z' - peopleArray[i]])
                        .reduce(0, Integer::sum),
                2);
    }

    static long solve(int N, int start, int finish, int[] ticketCost) {
        // Write your code here
        long result = 0;

        // If source is same as destination
        if (start == finish) {
            return result;
        }

        // Adjustment as index starts from 0
        start--;
        finish--;

        // Clock wise
        int current = start;
        int closeWiseCost = 0;
        while (current != finish) {
            closeWiseCost += ticketCost[current];
            current = (current + 1) % ticketCost.length;
        }

        // Anti Clock wise
        current = start;
        int antiCloseWiseCost = 0;
        while (current != finish) {
            current = current == 0 ? ticketCost.length - 1 : --current;
            antiCloseWiseCost += ticketCost[current];
        }

        result = Math.min(closeWiseCost, antiCloseWiseCost);

        return result;

    }
}
