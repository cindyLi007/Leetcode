package com.google.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicateLetters {
    // Time: O(N), although for some char, we maybe have multiple pop, for each char, we only have 1 time
    // push and one time pop
    public static String removeDuplicateLetters(String s) {
        int[] ch = new int[26];
        boolean[] visited = new boolean[26];
        for (char c : s.toCharArray()) ch[c - 'a']++;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            ch[i]--;
            /* must do this check. otherwise we will add duplicated char in stack
             */
            if (visited[i]) continue;
            visited[i] = true;
            while (!stack.isEmpty() && c < stack.peek() && ch[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pollLast());
        return sb.toString();
    }

    public static void main(String... args) {
//        String s = removeDuplicateLetters("cbacdcbc");
        String s = removeDuplicateLetters("ccc");
        System.out.println(s);
    }
}
