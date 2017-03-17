package com.cgi.collection;

import java.util.ArrayDeque;
import java.util.Deque;



/**
 * Created by ychang on 7/28/2016.
 */
public class DequeExample {

  public static void main(String[] args) {
    Deque<String> stack = new ArrayDeque<>();
    stack.push("one");
    stack.push("two");
    stack.push("three");

    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }

  }
}
