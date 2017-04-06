package com.google.recursive;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.stack.NestedInteger;

/**
 * Created by ychang on 1/9/2017. This can beat 95%
 */
public class NestedIterator implements Iterator<Integer> {
  Iterator<Integer> it;
  List<Integer> list;

  public NestedIterator(List<NestedInteger> nestedList) {
    list = new ArrayList();
    parse(nestedList);
    it = list.iterator();
  }

  private void parse(List<NestedInteger> nestedList) {
    for (NestedInteger ni : nestedList) {
      if (ni.isInteger()) {
        list.add(ni.getInteger());
      } else {
        parse(ni.getList());
      }
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
