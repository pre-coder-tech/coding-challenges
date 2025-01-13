package io.github.precodertech.codingjava;

class ReverseStrings {

    public static void main(String[] args) {
        /**
         * Reverse a string without using built-in functions.
         */
        System.out.println(reverseString("Wissen Technology"));
        System.out.println(reverseStatement("Wissen Technology"));
        System.out.println(reverseWordsMaintainPosition("Wissen Technology"));

        /**
         * Given a string s and an integer k, reverse the first k characters for
         * every 2k characters counting from the start of the string.
         * If there are fewer than k characters left, reverse all of them. If
         * there are less than 2k but greater than or equal to k characters,
         * then reverse the first k characters and leave the other as original.
         * Example 1:
         * Input: s = "abcdefg", k = 2 Output: "bacdfeg"
         * Example 2:
         * Input: s = "abcd", k = 2 Output: "bacd"
         */
        System.out.println(reverseStr("abcd", 2));

    }

    static String reverseStr(String s, int k) {
        if (s.length() < k) {
            return reverseString(s);
        }
        StringBuilder sb = new StringBuilder();
        for (int  i =0; i < s.length(); i+=2*k) {
            if (i+k < s.length()) {
                sb.append(reverseString(s.substring(i, i+k)));
                if (i+(2*k) < s.length()) {
                    sb.append(s.substring(i+k, i+(2*k)));
                } else {
                    sb.append(s.substring(i+k));
                }
                    
            } else {
                sb.append(reverseString(s.substring(i)));
            }
        }
        return sb.toString();
    }

    static String reverseWordsMaintainPosition(String originalStr) {
        String[] originalStrArr = originalStr.split(" ");
        String[] reversedStrArr = new String[originalStrArr.length];
        for (int i = 0; i < originalStrArr.length; i++) {
            reversedStrArr[i] = reverseString(originalStrArr[i]);
        }
        return String.join(" ", reversedStrArr);
    }

    static String reverseStatement(String originalStr) {
        String[] originalStrArr = originalStr.split(" ");
        String[] reversedStrArr = new String[originalStrArr.length];
        for (int i = originalStrArr.length - 1, j = 0; i >= 0; i--, j++) {
            reversedStrArr[j] = originalStrArr[i];
        }
        return String.join(" ", reversedStrArr);
    }

    static String reverseString(String originalString) {
        char[] reversedCharArray = new char[originalString.length()];
        for (int i = originalString.length() - 1, j = 0; i >= 0; i--, j++) {
            reversedCharArray[j] = originalString.charAt(i);
        }
        return String.valueOf(reversedCharArray);
    }
}
