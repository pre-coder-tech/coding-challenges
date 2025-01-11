package coding_challenges_java;

public class StringComputations {

    public static void main(String[] args) {
        // Find the first non-repeating character in a string.
        System.out.println(nonRepeatingCharOld("khgfsdnfvsfdvjhdkfhgwuregt"));
        System.out.println(nonRepeatingCharNew("khgfsdnfvsfdvjhdkfhgwuregt"));

         /**
         * Write a function to perform basic string compression using counts of
         * repeated characters. Input: "aaabbccdee" Output: "a3b2c2d1e2"
         */

    }

    static char nonRepeatingCharOld(String str) {
        char[] strCharArr = str.toCharArray();
        for (char c : strCharArr) {
            if (str.indexOf(c) == str.lastIndexOf(c)) {
                return c;
            }
        }
        return '0';
    }

    static char nonRepeatingCharNew(String str) {
        return (char) str
                .chars()
                .filter(c -> str.indexOf(c) == str.lastIndexOf(c))
                .findFirst()
        .orElse('0');
    }
}
