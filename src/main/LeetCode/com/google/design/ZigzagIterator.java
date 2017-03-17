package com.google.design;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 12/7/2016.
 */
public class ZigzagIterator {
  Deque<Iterator> list;

  public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
    list = new LinkedList<>();
    if (!v1.isEmpty())
      list.offer(v1.iterator());
    if (!v2.isEmpty())
      list.offer(v2.iterator());
  }

  public int next() {
    Iterator<Integer> first = list.poll();
    int result = first.next();
    if (first.hasNext()) list.offer(first);
    return result;
  }

  public boolean hasNext() {
    return !list.isEmpty();
  }
}
