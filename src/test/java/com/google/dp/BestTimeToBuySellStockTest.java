package com.google.dp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 3/7/2017.
 */
public class BestTimeToBuySellStockTest {
  @Test
  public void maxProfit() throws Exception {
    // Given
    int[] nums = new int[]{7,1,5,3,6,4};
    BestTimeToBuySellStock bestTimeToBuySellStock = new BestTimeToBuySellStock();

    // When
    int profit = bestTimeToBuySellStock.maxProfit(nums);

    assertThat(profit, is(5));
  }

}