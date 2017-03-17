package com.google.array;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by ychang on 1/4/2017.
 */
public class MergeIntervalTest {
  MergeInterval mergeInterval;
  Set<Integer> mock;
  @Before
  public void setUp() throws Exception {
    mergeInterval = new MergeInterval();
  }

  @Test
  public void merge() throws Exception {
    // Given
    List<Interval> list = Arrays.asList(new Interval[]{new Interval(2, 3), new Interval(4, 5),
    new Interval(6,7), new Interval(8, 9), new Interval(1, 10)});

    // When
    List<Interval> res = mergeInterval.merge(list);

    // Then

    }
}