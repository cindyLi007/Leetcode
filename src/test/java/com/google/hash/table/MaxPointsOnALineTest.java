package com.google.hash.table;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.awt.Point;

import org.junit.Test;

/**
 * Created by ychang on 2/16/2017.
 */
public class MaxPointsOnALineTest {
  @Test
  public void maxPoints() throws Exception {
    // Given
    Point[] points = new Point[]{new Point(0, 0), new Point(5,65536), new Point(5, 0), new Point(5, 10)};
    MaxPointsOnALine maxPointsOnALine = new MaxPointsOnALine();

    // When
    int res = maxPointsOnALine.maxPoints(points);

    // Then
    assertThat(res, is(3));
  }

}