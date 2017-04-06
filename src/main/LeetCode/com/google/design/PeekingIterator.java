package com.google.design;

import java.util.Iterator;

/**
 * Created by ychang on 3/31/2017.
 */
public class PeekingIterator implements Iterator<Integer> {
  Integer next;
  Iterator<Integer> iterator;

  public PeekingIterator(Iterator<Integer> iterator) {
    // initialize any member here.
    this.iterator=iterator;
  }

  // Returns the next element in the iteration without advancing the iterator.
  public Integer peek() {
    if (next==null) {
      next=iterator.next();
    }
    return next;
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public Integer next() {
    if (next==null) {
      return iterator.next();
    }
    Integer res = next;
    next=null;
    return res;
  }

  @Override
  public boolean hasNext() {
    return next!=null || iterator.hasNext();
  }
}
