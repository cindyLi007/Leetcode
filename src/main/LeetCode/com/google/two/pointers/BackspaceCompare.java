package com.google.two.pointers;

import java.util.Stack;

public class BackspaceCompare {
    // Time:O(M+N)
    public boolean backspaceCompare(String S, String T) {
        int i = S.length()-1, j = T.length()-1;
        // must be "or" instead of "and" because even one is run out and the other does not, they still can be same
        while (i>=0 || j>=0) {
            // make i and j stop in the first "useful" char which will show in final string
            i = process(S, i);
            j = process(T, j);
            if (i>=0 && j>=0 && S.charAt(i)!=T.charAt(j)) return false;
            if ((i>=0) != (j>=0)) return false;
            i--; j--;
        }
        return true;
    }

    private int process(String s, int i) {
        int back = 0;
        while (i>=0) {
            if (s.charAt(i)=='#') back++;
            else {
                if (back>0) back--;
                else return i;
            }
            i--;
        }
        return i;
    }

    public static void main(String... args) {
        BackspaceCompare backspaceCompare = new BackspaceCompare();
        boolean res = backspaceCompare.backspaceCompare("y#fo##f", "y#f#o##f");
        System.out.println(res);
    }

    // Time: O(N+M)
    public boolean backspaceCompare_Stack(String S, String T) {
        // process S and T and compare it
        String s = process(S), t = process(T);
        return s.equals(t);
    }

    private String process(String s) {
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (c=='#') {
                if(!stack.isEmpty()) stack.pop();
            }
            else stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
