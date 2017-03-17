package com.google.two.pointers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by ychang on 1/11/2017.
 */
public class ThreeSumTest {
  ThreeSum ts;

  @Before
  public void setUp() throws Exception {
    ts = new ThreeSum();
  }

  @Test
  public void threeSum() throws Exception {
    // Given
    int[] array = new int[]{1, -1, -1, 0};

    // When
    List<List<Integer>> lists = ts.threeSum(array);

    // Then
    assertThat(lists.size(), is(1));
    assertThat(lists, hasItems(Arrays.asList(-1, 0, 1)));
  }

}