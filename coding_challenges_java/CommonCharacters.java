package coding_challenges_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonCharacters {

    public static void main(String[] args) {
        /** common characters between two strings */
        commonCharacters("abc", "cbd");

        /* Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates).
         You may return the answer in any order. */
        System.out.println(commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println(commonChars(new String[]{"cool", "lock", "cook"}));
        System.out.println(commonChars(new String[]{"acabcddd", "bcbdbcbd", "baddbadb", "cbdddcac", "aacbcccd", "ccccddda", "cababaab", "addcaccd"}));
    }

    static List<String> commonChars(String[] words) {
        List<String> commonChars = new ArrayList<>();
        Map<String, Integer> charCount = getCharCount(words[0]);
        Map<String, Integer> commonCharMap = new HashMap<>(charCount);
        for (int index = 1; index < words.length; index++) {
            Map<String, Integer> tempCharCount = getCharCount(words[index]);
            for (String key : charCount.keySet()) {
                if (tempCharCount.containsKey(key) && commonCharMap.containsKey(key)) {
                    commonCharMap.put(key, Math.min(tempCharCount.get(key), commonCharMap.getOrDefault(key, charCount.get(key))));
                } else {
                    commonCharMap.remove(key);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : commonCharMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                commonChars.add(entry.getKey());
            }
        }
        return commonChars;
    }

    static Map<String, Integer> getCharCount(String str) {
        Map<String, Integer> charCount = new HashMap<>();
        for (char c : str.toCharArray()) {
            charCount.merge(String.valueOf(c), 1, Integer::sum);
        }
        return charCount;
    }

    static void commonCharacters(String str1, String str2) {
        String commonChars = "";
        for (char c : str2.toCharArray()) {
            if (str1.contains(String.valueOf(c))) {
                commonChars = commonChars + c;
            }
        }
        System.out.println(commonChars);
    }
}
