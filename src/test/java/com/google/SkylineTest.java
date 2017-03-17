package com.google;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by ychang on 1/2/2017.
 */
public class SkylineTest {
  Skyline skyline;
  @Before
  public void setUp() throws Exception {
    skyline = new Skyline();
  }

  @Test
  public void getSkyline() throws Exception {
    // Given
//    int[][] array = new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
    int[][] array = new int[][]{{0,2,3},{2,5,3}};

    // When
    List<int[]> result = skyline.getSkyline(array);

    // Then
//    assertThat(result, contains(new int[]{2, 10}, new int[]{3, 15}, new int[]{7, 12},
//        new int[]{12, 0}, new int[]{15, 10}, new int[]{20, 8}, new int[]{24, 0}));
    assertThat(result, contains(new int[]{0, 3}, new int[]{5, 0}));
  }

}