package com.google.array;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 8/16/2017.
 */
public class FindMinInRotatedSortedIITest {
  @Test
  public void findMin() throws Exception {
    // Given
    FindMinInRotatedSortedII findMinInRotatedSortedII = new FindMinInRotatedSortedII();

    // When
    int min = findMinInRotatedSortedII.findMin(new int[]{3, 3, 1, 3});

    // Then
    assertThat(min, is(1));
  }

}