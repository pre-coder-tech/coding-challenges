package coding_challenges_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagramPairs {

    public static void main(String[] args) {
        List<ArrayList<String>> anagramPairsOld = getAnagramPairs(new ArrayList<>(Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat")));
        System.out.println(anagramPairsOld);

        List<List<String>> anagramPairsNew = getAnagramPairsNew(new ArrayList<>(Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat")));
        System.out.println(anagramPairsNew);
    }

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
    @SuppressWarnings("unchecked")
    static List<ArrayList<String>> getAnagramPairs(List<String> inputStrs) {
        List<ArrayList<String>> anagramPairs = new ArrayList<>();
        ArrayList<String> pair = new ArrayList<>();
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
                anagramPairs.add((ArrayList<String>) pair.clone());
            }
        }
        return anagramPairs;
    }

    static boolean isAnagramPair(String str1, String str2) {
        char[] str1CharArr = str1.toCharArray();
        char[] str2CharArr = str2.toCharArray();
        Arrays.sort(str1CharArr);
        Arrays.sort(str2CharArr);
        return new String(str1CharArr).equals(new String(str2CharArr));
    }

    static List<List<String>> getAnagramPairsNew(List<String> inputStrs) {     
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
