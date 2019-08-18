package com.google.stack;

import java.util.Stack;

public class RemoveOuterParentheses {
    public static String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int count=0;
        for (char c : S.toCharArray()) {
            if (c=='(' && count++>0) sb.append(c);
            if (c==')' && --count>0) sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String... args) {
//        String res = removeOuterParentheses("(()())(())");
//        String res = removeOuterParentheses("(()())(())(()(()))");
//        String res = removeOuterParentheses("()()");
        String res = removeOuterParentheses("((()())(()()))");
        System.out.println(res);
    }
}
