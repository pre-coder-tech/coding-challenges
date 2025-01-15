package io.github.precodertech.codingjava;

import java.util.Stack;

public class CheckIfValidParenthesis {

    public static void main(String[] args) {
        /**
         * Check if a bracket is open then it is closed first before another
         * bracket is closed
         */

        System.out.println(ifValid("{}")); //true
        System.out.println(ifValid("[](){}")); //true
        System.out.println(ifValid("[)")); //false
        System.out.println(ifValid("([)]")); //false
        System.out.println(ifValid("([])")); //true
    }

    static boolean ifValid(String str) {

        if (str.charAt(0) == ')' || str.charAt(0) == ']' || str.charAt(0) == '}') {
            return false;
        }

        Stack<String> expectedClosingParanthesis = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '(' ->
                    expectedClosingParanthesis.push(")");
                case '[' ->
                    expectedClosingParanthesis.push("]");
                case '{' ->
                    expectedClosingParanthesis.push("}");
                case ')' -> {
                    if (!expectedClosingParanthesis.pop().contentEquals(")")) {
                        return false;
                    }
                }
                case ']' -> {
                    if (!expectedClosingParanthesis.pop().contentEquals("]")) {
                        return false;
                    }
                }
                case '}' -> {
                    if (!expectedClosingParanthesis.pop().contentEquals("}")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
