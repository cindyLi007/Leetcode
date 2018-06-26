package com.google.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class MaxStack {
  Deque<Integer> number;
  Deque<Integer> maxDeque;

  /** initialize your data structure here. */
  public MaxStack() {
    number = new ArrayDeque();
    maxDeque = new ArrayDeque();
  }

  public void push(int x) {
    number.push(x);
    maxDeque.push(Math.max(x, maxDeque.isEmpty() ? x : maxDeque.peek()));
  }

  public int pop() {
    if (number.isEmpty()) {
      throw new IllegalStateException("stack is empty");
    }
    maxDeque.pop();
    return number.pop();
  }

  public int top() {
    if (number.isEmpty()) {
      throw new IllegalStateException("stack is empty");
    }
    return number.peek();
  }

  public int peekMax() {
    if (number.isEmpty()) {
      throw new IllegalStateException("stack is empty");
    }
    return maxDeque.peek();
  }

  public int popMax() {
    if (number.isEmpty()) {
      throw new IllegalStateException("stack is empty");
    }
    Deque<Integer> temp = new ArrayDeque();
    int n = number.pop();
    while (n!=maxDeque.pop()) {
      temp.push(n);
      n=number.pop();
    }
    while (!temp.isEmpty()) {
      push(temp.pop());
    }
    return n;
  }
}
