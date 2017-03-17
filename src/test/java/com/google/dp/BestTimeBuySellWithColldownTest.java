package com.google.dp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 3/9/2017.
 */
public class BestTimeBuySellWithColldownTest {
  @Test
  public void maxProfit() throws Exception {
    // Given
    BestTimeBuySellWithColldown btbswc = new BestTimeBuySellWithColldown();
    int[] array = new int[]{2,1,4,5,2,9,7};

    // When
    int res = btbswc.maxProfit(array);

    assertThat(res, is(10));
  }

}