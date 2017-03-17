package com.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by ychang on 12/24/2016.
 */
public class OptimalAccountBalanceTest {
  OptimalAccountBalance instance;

  @Before
  public void setUp() throws Exception {
    instance = new OptimalAccountBalance();
  }

  @Test
  public void minTransfers() throws Exception {
    // Given
//    int[][] array = {{0, 1, 10}, {2, 0, 5}};
//    int[][] array = {{0,1,10},{1,0,1},{1,2,5},{2,0,5}};
    int[][] array = {{1,2,3},{1,3,3},{6,4,1},{5,4,4}};
//    int[][] array = {{0,1,1},{1,2,1},{2,0,1}};
//    int[][] array = {{1,5,8},{8,9,8},{2,3,9},{4,3,1}};

    // When
    int minTransfers = instance.minTransfers(array);

    // Then
    assertThat(minTransfers, is(4));
  }

}