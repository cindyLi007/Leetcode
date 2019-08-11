package com.google.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {
    // what we want to keep is left most is smallest, next left-most is 2nd smallest, and so on, so we need keep an
    // non-descending list, whenever, we encounter a num < stack top, pop stack and push the number in
    // Time: O(N), although for a char we do multiple pop, for each char, we do only once push and pop.
    public String removeKdigits(String num, int k) {
        if (num.length()<=k) return "0";
        Deque<Integer> stack = new ArrayDeque<>();
        int j=0;
        for (; j<num.length() && k>0; j++) {
            int i = num.charAt(j) -'0';
            while (k>0 && !stack.isEmpty() && i<stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(i);
        }
        String s = num.substring(j);
        while (!stack.isEmpty() && stack.peekLast()==0) stack.pollLast();
        StringBuilder sb = new StringBuilder();
        while (k>0) {
            stack.pop();
            k--;
        }
        while (!stack.isEmpty()) sb.append(stack.pollLast());
        sb.append(s);
        return sb.length()==0 ? "0" : sb.toString();
    }
}
