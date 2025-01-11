package coding_challenges_java;



public class StringPalindrome {

    public static void main(String[] args) {
        /**
         * Check if a string is a palindrome.
         */
        System.err.println("Is String 'MOM' a Palindrome?: " + isStringPalindromeTraditionalWay("MOM"));
        System.err.println("Is String 'ROTATOR' a Palindrome?: " + isStringPalindromeTraditionalWay("ROTATOR"));
        System.err.println("Is String 'step not on pets' a Palindrome?: " + isStringPalindromeTraditionalWay("step not on pets"));

        System.err.println("Is String 'MOM' a Palindrome?: " + isStringPalindromeFunctionalWay("MOM"));
        System.err.println("Is String 'ROTATOR' a Palindrome?: " + isStringPalindromeFunctionalWay("ROTATOR"));
        System.err.println("Is String 'step not on pets' a Palindrome?: " + isStringPalindromeFunctionalWay("step not on pets"));
    }

    static boolean isStringPalindromeTraditionalWay(String originalString) {
        String cleanedStr = originalString.replaceAll("\\s+", "");
        char[] reversedCharArray = new char[cleanedStr.length()];
        for (int i = cleanedStr.length() - 1; i >= 0; i--) {
            reversedCharArray[i] = cleanedStr.charAt(i);
        }
        return String.valueOf(reversedCharArray).equals(cleanedStr);
    }

    static boolean isStringPalindromeFunctionalWay(String originalString) {
        String cleanedStr = originalString.replaceAll("\\s+", "");
        String reversedStr = new StringBuilder(cleanedStr).reverse().toString();
        return reversedStr.equals(cleanedStr);
    }
}
