package com.google.array;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

/**
 * Created by ychang on 7/24/2017.
 */
public class FirstMissingPositiveTest {
  @Test
  public void firstMissingPositive() throws Exception {
    // Given
    FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
    int[] array = new int[]{-1, 4, 2, 1, 9, 10};

    // When
    int positive = firstMissingPositive.firstMissingPositive(array);

    // Then
    assertThat(positive, is(3));
  }

}