package com.google.binary.search;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 8/11/2017.
 */
public class MedianOfTwoSortedArrayTest {
  @Test
  public void findMedianSortedArrays() throws Exception {
    // Given
    MedianOfTwoSortedArray medianOfTwoSortedArray = new MedianOfTwoSortedArray();
    int[] array1 = new int[]{4, 5, 6, 8, 12, 15, 18};
    int[] array2 = new int[]{1, 2, 3, 10, 11, 13, 16};

    // when
    double result = medianOfTwoSortedArray.findMedianSortedArrays(array1, array2);

    // Then
    assertThat(result, is(9.0));
  }

}