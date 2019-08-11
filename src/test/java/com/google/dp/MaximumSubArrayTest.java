package com.google.dp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 3/7/2017.
 */
public class MaximumSubArrayTest {
  @Test
  public void maxSubArray() throws Exception {
    // Given
    MaximumSubArray maximumSubArray = new MaximumSubArray();
//    int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int[] array = new int[]{-904, 40, 523, 12, -335, -385, -124, 1481, -31};

    // When
//    int res = maximumSubArray.maxSubArray_DivideConquer(array);
    System.out.println(maximumSubArray.findMaximumSubarray(array));
    int[] res1 = maximumSubArray.maxSubArray(array);
    System.out.println(res1[0] + " " + res1[1] + " " + res1[2] );
    int[] res2 = maximumSubArray.maxSubArray_improve(array);
    System.out.println(res2[0] + " " + res2[1] + " " + res2[2] );

    // Then
//    assertThat(res, is(2116));

  }

}