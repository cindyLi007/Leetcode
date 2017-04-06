package com.google.two.pointers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 3/28/2017.
 */
public class SortTransformedArrayTest {
  @Test
  public void sortTransformedArray() throws Exception {
    // Given
    SortTransformedArray sortTransformedArray = new SortTransformedArray();
    int[] array = new int[]{-4, -2, 2, 4};

    // When
    int[] res = sortTransformedArray.sortTransformedArray(array, 1, 3, 5);

    // Then
    assertThat(res, is(new int[]{3, 9, 15, 33}));
  }

}