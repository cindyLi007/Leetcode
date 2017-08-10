package com.google.stack;

import java.util.Stack;

/**
 * Created by ychang on 8/8/2017.
 * Implement the following operations of a queue using stacks.
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 */
public class ImplementQueueUsingStack {
  Stack<Integer> s1, s2;

  /** Initialize your data structure here. */
  public ImplementQueueUsingStack() {
    s1=new Stack();
    s2=new Stack();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    s1.push(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    peek();
    return s2.pop();
  }

  /** Get the front element. */
  public int peek() {
    // only move from s1 from s2 when needed, elements in s2 is already in-order
    if (s2.isEmpty()) {
      while (!s1.isEmpty()) {
        s2.push(s1.pop());
      }
    }
    return s2.peek();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return s1.isEmpty() && s2.isEmpty();
  }
}
