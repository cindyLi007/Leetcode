package com.google.array;

import java.util.Arrays;

/**
 * Created by ychang on 3/10/2017.
 * This problem we need NOT consider min transactions, so we can buy, sell and buy in same day, sell
 * such as [3, 5, 9], buy 3, sell 5 and buy 5, sell 9, maxProfit is 6, equals buy 3 and sell 9.
 * So makes it easy, just need loop one time. anytime keep min as buy price, whenever find a higher price, sell it and
 * reset min, keep going on.
 */
public class BestTimeBuySellStockII {

  // leetcode 188. Time: O(N*k), Space: O(N)
  public int maxProfit_atMostK_Transactions(int k, int[] prices) {
    int N = prices.length;
    if (N<2) return 0;
    if (k>=N/2) { // we can do as many as possible transactions, there is no limitation
      return maxProfit(prices);
    }
    int[] t0=new int[k+1];
    int[] t1=new int[k+1];
    // for all j transactions (1<=j<=k), t1[j] always == -prices[0], because till 0-th day end, we can only hold prices[0]
    Arrays.fill(t1, -prices[0]);

    for (int i=1; i<N; i++) {
      // we need to update all the maximum profits with different k values corresponding to 0 or 1 stocks in hand at the end of the day.
      // must from k to 1(decresing order), because t1[j] depends on t0[j-1]
      for (int j=k; j>=1; j--) {
        t0[j]=Math.max(t0[j], t1[j] + prices[i]);
        // buy mean add a new transaction
        t1[j]=Math.max(t1[j], t0[j-1] - prices[i]);
      }
    }

    return t0[k];
  }

  // Leetcode 122, Time: O(N)
  private int maxProfit(int[] prices) {
    // t1 initial value means buy stock in 0-day, t0 means not buy in 0-day
    int t1=-prices[0], t0=0;
    for (int i=1; i<prices.length; i++) {
      int temp = t0;
      // keep previous value mean no-buy, no-sell, otherwise depends on "previous day opposite status" +/- "today's price"
      t0 = Math.max(t0, t1+prices[i]);
      t1 = Math.max(t1, temp-prices[i]);
    }
    return t0;
  }
}
