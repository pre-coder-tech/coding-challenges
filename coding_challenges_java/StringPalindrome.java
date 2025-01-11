package coding_challenges_java;



public class StringPalindrome {

    public static void main(String[] args) {
        /**
         * Check if a string is a palindrome.
         */
        System.err.println("Is String 'MOM' a Palindrome?: " + isStringPalindromeOld("MOM"));
        System.err.println("Is String 'ROTATOR' a Palindrome?: " + isStringPalindromeOld("ROTATOR"));
        System.err.println("Is String 'step not on pets' a Palindrome?: " + isStringPalindromeOld("step not on pets"));

        System.err.println("Is String 'MOM' a Palindrome?: " + isStringPalindromeNew("MOM"));
        System.err.println("Is String 'ROTATOR' a Palindrome?: " + isStringPalindromeNew("ROTATOR"));
        System.err.println("Is String 'step not on pets' a Palindrome?: " + isStringPalindromeNew("step not on pets"));
    }

    static boolean isStringPalindromeOld(String originalString) {
        String cleanedStr = originalString.replaceAll("\\s+", "");
        char[] reversedCharArray = new char[cleanedStr.length()];
        for (int i = cleanedStr.length() - 1; i >= 0; i--) {
            reversedCharArray[i] = cleanedStr.charAt(i);
        }
        return String.valueOf(reversedCharArray).equals(cleanedStr);
    }

    static boolean isStringPalindromeNew(String originalString) {
        String cleanedStr = originalString.replaceAll("\\s+", "");
        String reversedStr = new StringBuilder(cleanedStr).reverse().toString();
        return reversedStr.equals(cleanedStr);
    }
}
