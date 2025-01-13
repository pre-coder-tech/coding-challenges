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
         * Find the Index of the First Occurrence in a String Solved Given two
         * strings needle and haystack, return the index of the first occurrence
         * of needle in haystack, or -1 if needle is not part of haystack.
         * Example 1: Input: haystack = "sadbutsad", needle = "sad" Output: 0
         * Explanation: "sad" occurs at index 0 and 6. The first occurrence is
         * at index 0, so we return 0.
         *
         * Example 2: Input: haystack = "leetcode", needle = "leeto" Output: -1
         * Explanation: "leeto" did not occur in "leetcode", so we return -1.
         */
        System.out.println(strStr("mississippi", "pi"));
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("abc", "c"));
        System.out.println(strStr("a", "a"));
        System.out.println(strStr("sadbutmad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));

        /**
         * You are given a license key represented as a string s that consists
         * of only alphanumeric characters and dashes. The string is separated
         * into n + 1 groups by n dashes. You are also given an integer k.
         * 
         * We want to reformat the string s such that each group contains
         * exactly k characters, except for the first group, which could be
         * shorter than k but still must contain at least one character.
         * Furthermore, there must be a dash inserted between two groups, and
         * you should convert all lowercase letters to uppercase.

         * Return the reformatted license key.
         * 
         * Example 1:
         * Input: s = "5F3Z-2e-9-w", k = 4 Output: "5F3Z-2E9W" Explanation: The
         * string s has been split into two parts, each part has 4 characters.
         * Note that the two extra dashes are not needed and can be removed.
         * 
         * Example 2:
         * Input: s = "2-5g-3-J", k = 2 Output: "2-5G-3J" Explanation: The
         * string s has been split into three parts, each part has 2 characters
         * except the first part as it could be shorter as mentioned above.
         */
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }

    static String licenseKeyFormatting(String s, int k) {
        s = s.replaceAll("^-+", "").replaceAll("-+$", "");

        if (s.length() <= k) {
            return s.toUpperCase();
        }

        String[] groups = s.split("-");
        StringBuilder sb = new StringBuilder();
        String updatedString;
        if (groups.length > 1 && groups[0].length() < k) {
            sb.append(groups[0].toUpperCase());
            sb.append("-");
            updatedString = s.substring(groups[0].length()).replaceAll("-", "").toUpperCase();
        } else {
            updatedString = s.replaceAll("-", "").toUpperCase();
        }

        if (updatedString.length() % k != 0) {
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.lastIndexOf("-"));
            }
            sb.append(updatedString.substring(0, updatedString.length() % k));
            sb.append("-");
            updatedString = updatedString.substring(updatedString.length() % k);
        }
        for (int i = 0; i < updatedString.length(); i += k) {
            if (i != 0 && i < updatedString.length()) {
                sb.append("-");
            }
            if (i + k < updatedString.length()) {
                sb.append(updatedString.substring(i, i + k));
            } else {
                sb.append(updatedString.substring(i));
            }

        }
        if (sb.lastIndexOf("-") == sb.length() - 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
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
