package com.google.segment.tree;

import java.util.TreeMap;

class MyCalendarThree {
  TreeMap<Integer, Integer> tree;

  public MyCalendarThree() {
    tree = new TreeMap();
  }

  // Time: O(N), Space: O(N) N is the number of event
  public int book(int start, int end) {
    tree.put(start, tree.getOrDefault(start, 0) + 1);
    tree.put(end, tree.getOrDefault(end, 0) - 1);
    int k = 0, ongoing = 0;
    for (int v : tree.values()) {
      ongoing += v;
      k = Math.max(k, ongoing);
    }
    return k;
  }

  public static void main(String... args) {
    MyCalendarThree myCalendarThree = new MyCalendarThree();
    System.out.println(myCalendarThree.book(10, 20)); // should be 1
    System.out.println(myCalendarThree.book(50, 60)); // should be 1
    System.out.println(myCalendarThree.book(10, 40)); // should be 2
    System.out.println(myCalendarThree.book(5, 15)); // should be 3
    System.out.println(myCalendarThree.book(5, 10)); // should be 3
    System.out.println(myCalendarThree.book(25, 55)); // should be 3
  }
}
