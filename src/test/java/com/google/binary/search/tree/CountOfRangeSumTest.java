package com.google.binary.search.tree;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 6/14/2017.
 */
public class CountOfRangeSumTest {
  @Test
  public void countRangeSum() throws Exception {
    // Given
    CountOfRangeSum countOfRangeSum = new CountOfRangeSum();
    int[] array = new int[]{0};

    // When
    int rangeSum = countOfRangeSum.countRangeSum(array, 0, 0);

    // Then
    assertThat(rangeSum, is(1));
  }

}