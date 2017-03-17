package com.google.binary.search;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

/**
 * Created by ychang on 1/24/2017.
 */
public class FindMinInRotatedArrayTest {
  FindMinInRotatedArray fmira = new FindMinInRotatedArray();

  @Test
  public void findMin() throws Exception {
    // Given
    int[] array = new int[]{5, 6, 7, 0, 1, 2, 4};

    // When
    int min = fmira.findMin(array);

    // Then
    assertThat(min, is(0));
  }

}