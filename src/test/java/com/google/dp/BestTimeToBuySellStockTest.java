package com.google.dp;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by ychang on 3/7/2017.
 */
public class BestTimeToBuySellStockTest {
  @Test
  public void maxProfit() throws Exception {
    // Given
//    int[] nums = new int[]{7,1,5,3,6,4};
    int[] nums = new int[]{1, 2, 3, 0, 2};
    BestTimeToBuySellStock bestTimeToBuySellStock = new BestTimeToBuySellStock();

    // When
    int profit = bestTimeToBuySellStock.maxProfit_with1_dayCooldown(nums);

    assertThat(profit, is(5));
  }

}