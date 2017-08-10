package com.google.string;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 8/6/2017.
 */
public class StringToIntTest {
  @Test
  public void myAtoi() throws Exception {
    // Given
    StringToInt stringToInt = new StringToInt();
    char c = 'a';
    c ^= 256;
    System.out.println(c);

    // When
    int i = stringToInt.myAtoi("    010");

    // Then
    assertThat(i, is(10));
  }

}