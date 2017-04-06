package com.google.two.pointers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 3/29/2017.
 */
public class TrappingRainWaterTest {
  @Test
  public void trap() throws Exception {
    // Given
    TrappingRainWater trappingRainWater = new TrappingRainWater();
    int[] water = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

    // When
    int trap = trappingRainWater.trap(water);

    assertThat(trap, is(6));
  }

}