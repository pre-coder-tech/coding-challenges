package coding_challenges_java;

class ReverseStrings {

    public static void main(String[] args) {
        /** Reverse a string without using built-in functions. */
        System.out.println(reverseString("Wissen Technology"));
        System.out.println(reverseStatement("Wissen Technology"));
        System.out.println(reverseWordsMaintainPosition("Wissen Technology"));
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
