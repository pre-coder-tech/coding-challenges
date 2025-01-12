package io.github.precodertech.codingjava;

public class StringArrayPrefixCount {

    public static void main(String[] args) {
        System.out.println(prefixCount(new String[]{"pay", "attention", "practice", "attend"}, "at"));
        System.out.println(prefixCount(new String[]{"leetcode", "win", "loops", "success"}, "code"));
    }

    /**
     * You are given an array of strings words and a string pref.
     * Return the number of strings in words that contain pref as a prefix.
     * A prefix of a string s is any leading contiguous substring of s.
     *
     * @param words
     * @param pref
     * @return count (int)
     */
    static int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }
}
