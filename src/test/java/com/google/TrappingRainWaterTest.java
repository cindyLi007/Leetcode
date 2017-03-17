package com.google;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

import com.google.dp.TrappingRainWater;

/**
 * Created by ychang on 1/3/2017.
 */
public class TrappingRainWaterTest {
  TrappingRainWater trappingRainWater;
  @Before
  public void setUp() throws Exception {
    trappingRainWater = new TrappingRainWater();
  }

  @Test
  public void trap() throws Exception {
    // Given
//    int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int[] height = new int[]{5,2,1,2,1,5};

    // When
    int res = trappingRainWater.trap(height);

    // Then
    assertThat(res, is(14));
  }

}