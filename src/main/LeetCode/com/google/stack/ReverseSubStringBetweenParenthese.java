package com.google.stack;

import java.util.Stack;

public class ReverseSubStringBetweenParenthese {
  int i = 0; // this is global var for recursive

  // Time: O(N^2) because we need reverse substring
  public String reverseParentheses_recursive(String s) {
    StringBuilder sb = new StringBuilder();
    while (i < s.length()) {
      char c = s.charAt(i++);
      if (c == '(') {
        String sub = reverseParentheses_recursive(s);
        StringBuilder temp = new StringBuilder(sub);
        sb.append(temp.reverse());
      } else if (c == ')') {
        return sb.toString();
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }

  // Time: O(N^2) because we need reverse substring
  public String reverseParentheses(String s) {
    Stack<String> stack = new Stack();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        stack.push(sb.toString());
        sb = new StringBuilder();
      } else if (c == ')') {
        sb = new StringBuilder(stack.pop() + sb.reverse().toString());
      } else sb.append(c);
    }
    return sb.toString();
  }

  public static void main(String... args) {
    ReverseSubStringBetweenParenthese instance = new ReverseSubStringBetweenParenthese();
    System.out.println(instance.reverseParentheses("(abcd)")); // dcba
    System.out.println(instance.reverseParentheses("(u(love)i)")); //iloveu
    System.out.println(instance.reverseParentheses("(ed(et(oc))el)")); //leetcode
    System.out.println(instance.reverseParentheses("a(bcdefghijkl(mno)p)q")); //apmnolkjihgfedcbq
  }
}
