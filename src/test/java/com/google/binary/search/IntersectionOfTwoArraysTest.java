package com.google.binary.search;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

/**
 * Created by ychang on 1/28/2017.
 */
public class IntersectionOfTwoArraysTest {
  IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();

  @Test
  public void intersection_twoPointer() throws Exception {
    // Given
    int[] array = new int[]{1, 2, 2, 1};
    int[] array_1 = new int[]{2};

    // When
    int[] res = intersectionOfTwoArrays.intersection_twoPointer(array_1, array);

    assertThat(res, is(new int[]{2}));
  }

}