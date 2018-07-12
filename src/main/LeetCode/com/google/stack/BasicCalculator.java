package com.google.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -,
 * non-negative integers and empty spaces.
 * <p>
 * Leetcode 224
 */
public class BasicCalculator {
  public int calculate(String s) {
    Deque<Integer> deque = new ArrayDeque();
    int res = 0;
    int sign = 1;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      // sum before encounter a parentheses
      if (Character.isDigit(c)) {
        int num = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
          num = num * 10 + s.charAt(i++) - '0';
        }
        i--;
        res += num * sign;
      } else if (c == '+') {
        sign = 1;
      } else if (c == '-') {
        sign = -1;
      } else if (c == '(') { // need store prev res in stack, and restart new sum, also store the sign before parentheses
        deque.push(res);
        deque.push(sign);
        res = 0;
        sign = 1;
      } else if (c == ')') { // now res is the sum in parentheses, first pop the sign before parentheses, then sum with prev res
        res = res * deque.pop() + deque.pop();
      }
    }

    return res;
  }
}
