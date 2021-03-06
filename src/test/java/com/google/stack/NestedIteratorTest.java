package com.google.stack;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Created by ychang on 1/9/2017.
 */
public class NestedIteratorTest {
  NestedIterator nestedIterator;

  @Test
  public void next() throws Exception {
    // Given
    List<NestedInteger> list = new ArrayList<>();
    NestedInteger ni_1 = new NestedIntegerImpl();
    ni_1.add(new NestedIntegerImpl(1));
    ni_1.add(new NestedIntegerImpl(1));
    list.add(ni_1);
    list.add(new NestedIntegerImpl(2));
    list.add(ni_1);
    NestedIterator nestedIterator = new NestedIterator(list);

    // When
    System.out.println(nestedIterator.next());
    System.out.println(nestedIterator.next());
    System.out.println(nestedIterator.next());
    System.out.println(nestedIterator.next());
    System.out.println(nestedIterator.next());
    nestedIterator.hasNext();
  }

  @Test
  public void hasNext() throws Exception {

  }

}