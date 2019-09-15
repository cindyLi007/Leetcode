package com.google.dp;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by ychang on 5/22/2017.
 */
public class CombinationSum4Test {
  @Test
  public void combinationSum4() throws Exception {
    // Given
    CombinationSum4 combinationSum4 = new CombinationSum4();

    // When
    int sum4 = combinationSum4.combinationSum4(new int[]{1, 2, 3}, 4);

    // Then
    assertThat(sum4, is(6));
  }

}