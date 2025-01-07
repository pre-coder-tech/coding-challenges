import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindVowels {
    public static void main(String[] args) {
        String str = "hgdfvmoiutfywehfbdjapsdofkadsjbfpwe";
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Map<Character, Integer> vowelsCount = new HashMap<>();
        for(char s: str.toCharArray()) {
            if (vowels.contains(s)) {
                if (vowelsCount.containsKey(s)) {
                    vowelsCount.put(s, vowelsCount.get(s) + 1);
                } else {
                    vowelsCount.put(s, 1);
                } 
            }
        }

        System.out.println(vowelsCount.toString());
    }
}
