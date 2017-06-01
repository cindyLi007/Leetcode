package com.google.dp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 5/30/2017.
 */
public class PartitionEqualSubsetSumTest {
  @Test
  public void canPartition() throws Exception {
    // Given
    PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();

    // When
    boolean canPartition = partitionEqualSubsetSum.canPartition(new int[]{100,100,100,100,100,100,100,100,100,100,100,
        100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
        100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
        100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
        100,100,100,100,100});

    // Then
    assertThat(canPartition, is(Boolean.TRUE));
  }

}