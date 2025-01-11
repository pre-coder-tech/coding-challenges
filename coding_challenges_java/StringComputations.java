package coding_challenges_java;

import java.util.Map;
import java.util.TreeMap;

public class StringComputations {

    public static void main(String[] args) {
        // Find the first non-repeating character in a string.
        System.out.println(nonRepeatingCharTraditionalWay("khgfsdnfvsfdvjhdkfhgwuregt"));
        System.out.println(nonRepeatingCharFunctionalWay("khgfsdnfvsfdvjhdkfhgwuregt"));

        /**
         * Write a function to perform basic string compression using counts of
         * repeated characters. Input: "aaabbccdee" Output: "a3b2c2d1e2"
         */
        stringCompressionUsingCount("aaabbbcccdddee");
        stringCompressionUsingCount("jhgdsdferhksdfywfsd");

        /* swap characters in strings at specific positions. */
        System.out.println(swapCharacters("Hello", 1, 4));
    }

    static String swapCharacters(String str, int fromPosition, int toPosition) {
        StringBuilder stringBuilder = new StringBuilder(str);
        char temp = stringBuilder.charAt(fromPosition);
        stringBuilder.setCharAt(fromPosition, stringBuilder.charAt(toPosition));
        stringBuilder.setCharAt(toPosition, temp);
        return stringBuilder.toString();
    }

    static void stringCompressionUsingCount(String str) {
        Map<Character, Integer> compressionCount = new TreeMap<>();
        for (char c: str.toCharArray()) {
            compressionCount.merge((char) c, 1, Integer::sum);
        }  
        for (Map.Entry<Character, Integer> en : compressionCount.entrySet()) {
            System.out.print(en.getKey() + "" + en.getValue()); 
        }
        System.out.println();
    }

    static char nonRepeatingCharTraditionalWay(String str) {
        char[] strCharArr = str.toCharArray();
        for (char c : strCharArr) {
            if (str.indexOf(c) == str.lastIndexOf(c)) {
                return c;
            }
        }
        return '0';
    }

    static char nonRepeatingCharFunctionalWay(String str) {
        return (char) str
                .chars()
                .filter(c -> str.indexOf(c) == str.lastIndexOf(c))
                .findFirst()
                .orElse('0');
    }
}
