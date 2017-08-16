package com.google.dp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 8/14/2017.
 */
public class HouseRobberIITest {
  @Test
  public void rob() throws Exception {
    // Given
    HouseRobberII robberII = new HouseRobberII();

    // When
    int amount = robberII.rob(new int[]{2, 1, 1, 2});

    // Then
    assertThat(amount, is(3));
  }

}