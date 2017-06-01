package com.google.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 5/7/2017.
 */
public class MultiplyStringTest {
  @Test
  public void multiply() throws Exception {
    // Given
    MultiplyString multiplyString = new MultiplyString();

    // When
    String res = multiplyString.multiply("1", "1");

    // Then
    assertThat(res, is("1"));
  }

}