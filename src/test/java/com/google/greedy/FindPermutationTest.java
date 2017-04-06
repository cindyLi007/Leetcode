package com.google.greedy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 3/29/2017.
 */
public class FindPermutationTest {
  @Test
  public void findPermutation() throws Exception {
    // Given
    FindPermutation findPermutation = new FindPermutation();

    // When
    int[] permutation = findPermutation.findPermutation("DDDDIIIIII");

    // Then
    assertThat(permutation, is(new int[]{5, 4, 3, 2, 1, 6, 7, 8, 9, 10, 11}));
  }

}