package com.google.recursive;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

import com.google.stack.NestedInteger;

/**
 * Created by ychang on 1/9/2017. This can beat 95%
 */
public class NestedIterator implements Iterator<Integer> {
  /**
   * An iterator shouldn't copy the entire data, but just iterate over the original data structure, it works as a pointer.
   * So we should NOT use this way to design NestedIterator
   */
/*
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
*/
  /**
   * this is the correct way, stack only save "pointers to each layer NestedList"
    */
  private Stack<ListIterator<NestedInteger>> stack;

  public NestedIterator(List<NestedInteger> nestedList) {
    stack = new Stack();
    stack.push(nestedList.listIterator());
  }

  @Override
  public Integer next() {
    /**
     * call hasNext() in next() in case user does not call hasNext() before, we need use hasNext to pre-process iterator
     */
    hasNext();
    return stack.peek().next().getInteger();
  }

  @Override
  public boolean hasNext() {
    while (!stack.isEmpty()) {
      if (!stack.peek().hasNext()) { // if current iterator run out of elements
        stack.pop();
      } else {
        NestedInteger x = stack.peek().next(); // pick top iterator's next element
        if (x.isInteger()) {
          stack.peek().previous(); // move back cursor position
          return true;
        } else {
          stack.push(x.getList().listIterator()); // go to deeper layer
        }
      }
    }
    return false;
  }
}
