package com.google.stack;

import java.util.Stack;

/**
 * Created by ychang on 1/24/2017.
 */
public class ValidParentheses {
  public boolean isValid(String s) {
    if (s==null || s.length()==0) {
      return true;
    }
    /**
     * this step can improve performance
     */
    if (s.length()%2==1) {
      return false;
    }

    Stack<Character> stack = new Stack();
    for (char c : s.toCharArray()) {
      if (c=='(' || c=='{' || c=='[') {
        stack.push(c);
      } else {
        /**
         * this step is important, otherwise will have EmptyStackException.
         */
        if (stack.isEmpty()) {
          return false;
        }
        char left = stack.pop();
        if ((c==')' && left=='(') || (c=='}' && left=='{') || (c==']' && left=='[')) {
          continue;
        } else {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
