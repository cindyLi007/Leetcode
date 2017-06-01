package com.google.string;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 5/11/2017.
 */
public class RomanToIntTest {
  @Test
  public void romanToInt() throws Exception {
    // Given
    RomanToInt romanToInt = new RomanToInt();

    // When
    int res = romanToInt.romanToInt("DCCCXCIV");

    // Then
    assertThat(res, is(894));
  }

}