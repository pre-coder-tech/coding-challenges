package io.github.precodertech.codingjava;

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

        /* Write programs to count repeated words in a sentence. */
        System.out.println(countWords("Given an array of integers arr, return true if and only if it is a valid mountain array."));
        System.out.println(countWords("a set of words that is complete in itself, typically containing a subject and predicate, conveying a statement, question, exclamation, or command, and consisting of a main clause and sometimes one or more subordinate clauses."));

        /**
         *
         * Find the Index of the First Occurrence in a String Solved  
         * Given two strings needle and haystack, return the index of
         * the first occurrence of needle in haystack, or -1 if needle is not
         * part of haystack.
         * Example 1:
         * Input: haystack = "sadbutsad", needle = "sad" Output: 0 Explanation:
         * "sad" occurs at index 0 and 6. The first occurrence is at index 0, so
         * we return 0. 
         * 
         * Example 2:
         * Input: haystack = "leetcode", needle = "leeto" Output: -1
         * Explanation: "leeto" did not occur in "leetcode", so we return -1.
         */
        System.out.println(strStr("mississippi", "pi"));
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("abc", "c"));
        System.out.println(strStr("a", "a"));
        System.out.println(strStr("sadbutmad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
    }

    static int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        } else if (needle.length() == 1) {
            return haystack.indexOf(needle);
        } else {
            for (int index = 0; index <= haystack.length() - needle.length(); index++) {
                String subString = haystack.substring(index, index + needle.length());
                if (subString.equals(needle)) {
                    return index;
                }
            }
        }
        return -1;
    }

    static Integer countWords(String sentence) {
        String cleanedSentence = sentence.replace("[^a-zA-Z0-9 ]", "");
        String[] splitSentence = cleanedSentence.split("\\s+");
        TreeMap<String, Integer> countWordsMap = new TreeMap<>();
        for (String word : splitSentence) {
            countWordsMap.merge(word, 1, Integer::sum);
        }
        int count = 0;
        for (String word : countWordsMap.keySet()) {
            if (countWordsMap.get(word) > 1) {
                count++;
            }
        }
        return count;
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
        for (char c : str.toCharArray()) {
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
