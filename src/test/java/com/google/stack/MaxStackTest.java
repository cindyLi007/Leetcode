package com.google.stack;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MaxStackTest {

  @Test
  public void push() {
    // Given
    MaxStack maxStack = new MaxStack();

    // When
    maxStack.push(5);
    maxStack.push(1);
    maxStack.push(-5);
    int max = maxStack.popMax();
    int popMax = maxStack.popMax();
    int top = maxStack.top();

    // Then
    assertThat(max, is(5));
    assertThat(popMax, is(1));
    assertThat(top, is(-5));
  }
}