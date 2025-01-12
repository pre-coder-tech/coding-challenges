package io.github.precodertech.codingjava;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommonWords {

    public static void main(String[] args) {

        /**
         * Given a string paragraph and a string array of the banned words
         * banned, return the most frequent word that is not banned. It is
         * guaranteed there is at least one word that is not banned, and that
         * the answer is unique.
         *
         *          *The words in paragraph are case-insensitive and the answer should
         * be returned in lowercase.
         */
        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
        System.out.println(mostCommonWord("a.", new String[]{}));
        System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));



    }

    static String mostCommonWord(String paragraph, String[] banned) {
        String cleanedPara = paragraph.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", " ");
        String[] words = cleanedPara.split("\\s+");
        Map<String, Integer> wordCounter = new HashMap<>();
        for (String word: words) {
            if(!(Arrays.asList(banned)).contains(word)) {
                wordCounter.merge(word, 1, Integer::sum);
            }
        }
        String mostCommonWord = "";
        for(String key: wordCounter.keySet()) {
            if (mostCommonWord.isBlank() || wordCounter.get(mostCommonWord) < wordCounter.get(key)) {
                mostCommonWord = key;
            }
        }

        return mostCommonWord;

    }

}
