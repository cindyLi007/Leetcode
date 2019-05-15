package com.google.stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by ychang on 1/9/2017.
 * The reason we use Stack is the Data Structure is nested. For all manipulation of nested Data Structure,
 * first consider Stack. Such as Decode String
 *
 * refer {@link com.google.recursive.NestedIterator}
 */
public class NestedIterator implements Iterator<Integer> {
  Stack<NestedInteger> stack = new Stack();

  /** because of the first-in-last-out factor of stack, we need push the last element first and first element last
   * Here, we need NOT consider whether a element is empty list
   */
  public NestedIterator(List<NestedInteger> nestedList) {
    for (int i = nestedList.size() - 1; i>=0; i--) {
      stack.push(nestedList.get(i));
    }
  }

  @Override
  public Integer next() {
    return stack.pop().getInteger();
  }

  @Override
  public boolean hasNext() {
    while (!stack.isEmpty()) {
      if (stack.peek().isInteger())
        return true;
      NestedInteger top = stack.pop();
      /**
       * recursive flat the nested list, guarantee the first element always on the top of the stack
       */
      List<NestedInteger> tempList = top.getList();
      for (int i = tempList.size() - 1; i>=0; i--) {
        stack.push(tempList.get(i));
      }
    }
    return false;
  }
}
