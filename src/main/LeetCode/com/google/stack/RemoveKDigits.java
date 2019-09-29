package com.google.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {
    // what we want to keep is left most is smallest, next left-most is 2nd smallest, and so on, so we need keep an
    // non-descending list, whenever, we encounter a num < stack top, pop stack and push the number in
    // Time: O(N), although for a char we do multiple pop, for each char, we do only once push and pop.
    public static String removeKdigits_1(String num, int k) {
        if (k>=num.length()) return "0";
        Deque<Character> deque = new ArrayDeque<>();
        for (char n : num.toCharArray()) {
            while (k>0 && !deque.isEmpty() && deque.peekLast() > n) {
                deque.removeLast();
                k--;
            }
            deque.offerLast(n);
        }
        StringBuilder sb = new StringBuilder();
        // if a number is ascending order, we do not have chance to remove char, so need remove the last char(s)
        while (k>0) {
            deque.pollLast(); k--;
        }
        while (!deque.isEmpty()) {
            char n = deque.pollFirst();
            if (n=='0' && sb.length()==0) continue;
            sb.append(n);
        }
        return sb.length()==0 ? "0" : sb.toString();
    }

    public static void main(String... args) {
        System.out.println(removeKdigits_1("1432219", 3));
    }
}
