package com.google.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by ychang on 6/23/2017.
 */
public class LinkedQueue {

  public static void main(String[] args) {
    Deque<Integer> queue = new LinkedList<>();
    queue.offer(1);
    queue.offer(2);
    queue.offer(3);
    queue.offer(4);
    queue.offer(5);
    System.out.println(queue.getFirst() + " should be 1");
    System.out.println(queue.getLast() + " should be 5");
    System.out.println(queue.pollFirst() + " should be 1");
    System.out.println(queue.pollLast() + " should be 5");
    queue.remove();
    System.out.println();
  }
}
