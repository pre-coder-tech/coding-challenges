package coding_challenges_java;

import java.util.HashMap;

class DataTypeCounting {

    public static void main(String[] args) {
        /**
         * Identify the different data types present in an input string and
         * report their counts. Each of the substrings, separated by one or more
         * spaces, is one of either the String, Integer, or Double type.
         */
        typeCounter("John had bought 10 apples at Rs. 20.5 each.");
        typeCounter("The counter movement reaches the starting point of the first movement in the west--Paris--and subsides.");
        typeCounter("Hello my 50 name 4.5 is James, I 20 years old and I have 5.7 coins");
        typeCounter("can you give me 10 bucks puff in 7.5 or 7"); // with only 1 space in between
        typeCounter("can you     give me 10 bucks puff in 7.5 or 7"); // including more than 1 space

    }

    public static void typeCounter(String sentence) {
        System.out.println("For the Sentence: " + sentence);
        HashMap<String, Integer> typeCount = new HashMap<>();
        typeCount.put("string", 0);
        typeCount.put("integer", 0);
        typeCount.put("double", 0);
        String cleanedStr = sentence.replaceAll("[^a-zA-Z0-9. ]", "");
        String[] sentenceSplit = cleanedStr.split("\\s+");
        for (String s : sentenceSplit) {
            if (s.matches("\\d+")) {
                typeCount.merge("integer", 1, Integer::sum);
            } else if (s.matches("(\\d+).(\\d+)")) {
                typeCount.merge("double", 1, Integer::sum);
            } else {
                typeCount.merge("string", 1, Integer::sum);
            }
        }
        System.out.println("string " + typeCount.get("string"));
        System.out.println("integer " + typeCount.get("integer"));
        System.out.println("double " + typeCount.get("double"));
        System.out.println("=============================================");
    }

}
