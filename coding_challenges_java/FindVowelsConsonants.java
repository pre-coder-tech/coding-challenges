package coding_challenges_java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindVowelsConsonants {

    public static void main(String[] args) {
        /**
         * Count the number of vowels and consonants in a string.
         */
        System.out.println(findVowelsOld("hgdfvmoiutfywehfbdjapsdofkadsjbfpwe"));
        System.out.println(findVowelsNew("hgdfvmoiutfywehfbdjapsdofkadsjbfpwe"));

        System.out.println(findConsonantsOld("hgdfvmoiutfywehfbdjapsdofkadsjbfpwe"));
        System.out.println(findConsonantsNew("hgdfvmoiutfywehfbdjapsdofkadsjbfpwe"));

    }

    static String findVowelsOld(String str) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Map<Character, Integer> vowelsCount = new HashMap<>();
        for (char s : str.toCharArray()) {
            if (vowels.contains(s)) {
                vowelsCount.put(s, vowelsCount.containsKey(s) ? vowelsCount.get(s) + 1 : 1);
            }
        }
        return vowelsCount.toString();
    }

    static String findVowelsNew(String str) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Map<Character, Integer> vowelsCount = new HashMap<>();
        str.chars()
                .filter(c -> vowels.contains((char) c))
                .forEach(c -> vowelsCount.merge((char) c, 1, Integer::sum));

        /* Map<Character, Integer> vowelsCount = str.chars()
        .filter(c -> vowels.contains((char) c))
        .mapToObj(c -> (char) c)
        .collect(Collectors.toMap(
                c -> c,
                c -> 1,
                Integer::sum
        ));
        This is also a way to achieve the same */
        return vowelsCount.toString();
    }

    static String findConsonantsOld(String str) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Map<Character, Integer> consonantsCount = new HashMap<>();
        for (char s : str.toCharArray()) {
            if (!vowels.contains(s)) {
                consonantsCount.put(s, consonantsCount.containsKey(s) ? consonantsCount.get(s) + 1 : 1);
            }
        }
        return consonantsCount.toString();
    }

    static String findConsonantsNew(String str) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Map<Character, Integer> consonantsCount = new HashMap<>();
        str.chars()
                .filter(c -> !vowels.contains((char) c))
                .forEach(c -> consonantsCount.merge((char) c, 1, Integer::sum));

        /* Map<Character, Integer> consonantsCount = str.chars()
        .filter(c -> vowels.contains((char) c))
        .mapToObj(c -> (char) c)
        .collect(Collectors.toMap(
                c -> c,
                c -> 1,
                Integer::sum
        ));
        This is also a way to achieve the same */
        return consonantsCount.toString();
    }
}
