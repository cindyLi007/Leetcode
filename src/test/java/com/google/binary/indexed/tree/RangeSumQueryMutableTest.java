package com.google.binary.indexed.tree;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 6/12/2017.
 */
public class RangeSumQueryMutableTest {
  @Test
  public void sumRange() throws Exception {
    // Given
    RangeSumQueryMutable rangeSumQueryMutable = new RangeSumQueryMutable(new int[]{-1});

    // When
    int sum1 = rangeSumQueryMutable.sumRange(0, 0);
    rangeSumQueryMutable.update(0, 1);
    int sum2 = rangeSumQueryMutable.sumRange(0, 0);

    // Then
    assertThat(sum1, is(-1));
    assertThat(sum2, is(1));
  }

  @Test
  public void sumRange_segmentTree() {
    // Given
    int[] array = new int[]{9, -8};
    com.google.binary.segment.tree.RangeSumQueryMutable rangeSumQueryMutable = new com.google.binary.segment.tree.RangeSumQueryMutable(array);

    // When
    rangeSumQueryMutable.update(0, 3);
    int single = rangeSumQueryMutable.sumRange(1, 1);
    int sum = rangeSumQueryMutable.sumRange(0, 1);
    rangeSumQueryMutable.update(1, -3);
    int sum1 = rangeSumQueryMutable.sumRange(0, 1);

    // Then
    assertThat(single, is(-8));
    assertThat(sum, is(-5));
    assertThat(sum1, is(0));

  }

}