package com.google.stack;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

/**
 * Created by ychang on 1/23/2017.
 */
public class MinStackTest {
  MinStack minStack = new MinStack();

  @Test
  public void test() throws Exception {
    //["MinStack","push","push","push","getMin","pop","top","getMin"]
//    [[],[-2],[0],[-3],[],[],[],[]]

    // Given
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);

    // When
    int res1 = minStack.getMin();
    minStack.pop();
    int top = minStack.top();
    int res2 = minStack.getMin();

    // then
    assertThat(res1, is(-3));
    assertThat(top, is(0));
    assertThat(res2, is(-2));
  }

}