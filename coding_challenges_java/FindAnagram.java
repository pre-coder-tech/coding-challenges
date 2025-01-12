package coding_challenges_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagram {

    public static void main(String[] args) {
        /**
         * Write a program to check if two strings are anagrams of each other.
         */
        System.out.println("Are Strings 'aht' & 'hmt' anagram?: " + isAnagramPair("aht", "hmt"));
        System.out.println("Are Strings 'idj' & 'iks' anagram?: " + isAnagramPair("idj", "iks"));
        System.out.println("Are Strings 'pka' & 'apk' anagram?: " + isAnagramPair("pka", "apk"));
        System.out.println("Are Strings 'tap' & 'pat' anagram?: " + isAnagramPair("tap", "pat"));

        /*
        * Given an array of strings strs, group the anagrams together. 
        * You can return the answer in any order.
        *
        * Example 1:
        *
        * Input: strs = ["eat","tea","tan","ate","nat","bat"]
        *
        * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
         */
        List<List<String>> anagramPairsTraditionalWay = getAnagramPairs(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(anagramPairsTraditionalWay);

        List<List<String>> anagramPairsFunctionalWay = getAnagramPairsFunctionalWay(new ArrayList<>(Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat")));
        System.out.println(anagramPairsFunctionalWay);

    }

    static List<List<String>> getAnagramPairs(String[] strs) {
        Map<String, List<String>> anagramPairs = new HashMap<>();

        for (String str: strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = String.valueOf(charArray);

            anagramPairs.putIfAbsent(sortedStr, new ArrayList<>());
            anagramPairs.get(sortedStr).add(str);
        }
        return new ArrayList<>(anagramPairs.values());

    }

    /*  The Time Complexity is O(n^2) hence won't suitable for very large arrays
    static List<List<String>> getAnagramPairs(List<String> inputStrs) {
        List<List<String>> anagramPairs = new ArrayList<>();
        List<String> pair = new ArrayList<>();
        List<String> skipStrs = new ArrayList<>();
        for (int i = 0; i < inputStrs.size(); i++) {
            pair.clear();
            pair.add(inputStrs.get(i));
            if (!skipStrs.contains(inputStrs.get(i))) {
                for (int j = i + 1; j < inputStrs.size(); j++) {
                    if (isAnagramPair(inputStrs.get(i), inputStrs.get(j))) {
                        pair.add(inputStrs.get(j));
                        skipStrs.add(inputStrs.get(j));
                    }
                }
                anagramPairs.add(new ArrayList<>(pair));
            }
        }
        return anagramPairs;
    } */

    static boolean isAnagramPair(String str1, String str2) {
        char[] str1CharArr = str1.toCharArray();
        char[] str2CharArr = str2.toCharArray();
        Arrays.sort(str1CharArr);
        Arrays.sort(str2CharArr);
        return new String(str1CharArr).equals(new String(str2CharArr));
    } 

    static List<List<String>> getAnagramPairsFunctionalWay(List<String> inputStrs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        inputStrs.forEach(str -> {
            String sortedStr = str.chars()
                    .sorted()
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            anagramMap.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        });

        return new ArrayList<>(anagramMap.values());
    }
}
