package com.google.stack;

import java.util.Stack;

/**
 * Created by ychang on 1/23/2017.
 * Save minimum value in stack. When push a less-than-min-value to stack, first push current min in stack, then push that
 * value. When pop the minimum value, that means the entry after this value is the minimum value without this value,
 * pop that entry and update min value
 */
public class MinStack {
  Stack<Integer> stack;
  int min;

  public MinStack() {
    stack = new Stack();
    min = Integer.MAX_VALUE;
  }

  public void push(int x) {
    if (x<=min) { // even x==min, still need push into stack
      // save before-push-x-min-value to stack
      stack.push(min);
      min = x;
    }
    stack.push(x);
  }

  public void pop() {
    if (min==stack.peek()) {
      stack.pop();
      min = stack.pop();
    } else {
      stack.pop();
    }
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return min;
  }
}