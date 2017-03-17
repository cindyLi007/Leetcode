package com.google.recursive;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.google.stack.NestedInteger;

/**
 * Created by ychang on 1/9/2017.
 */
public class NestedIterator implements Iterator<Integer> {
  Queue<Integer> q = new LinkedList();
  Iterator<Integer> it;

  public NestedIterator(List<NestedInteger> nestedList) {
    makeQueue(nestedList);
    it = q.iterator();
  }

  private void makeQueue(List<NestedInteger> list) {
    for (NestedInteger ni : list) {
      if (ni.isInteger())
        q.add(ni.getInteger());
      else
        makeQueue(ni.getList());
    }
  }

  @Override
  public Integer next() {
    return it.next();
  }

  @Override
  public boolean hasNext() {
    return it.hasNext();
  }
}
