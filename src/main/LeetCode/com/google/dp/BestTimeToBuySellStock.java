package com.google.dp;

/**
 * Created by ychang on 3/7/2017. We need dynamic keep min when we loop from left to right, each time we update 2 things
 * 1. minValue, 2 maxDiff. because ith element can be minValue or maxValue
 */
public class BestTimeToBuySellStock {
  public int maxProfit(int[] prices) {
    if (prices==null || prices.length<=1) return 0;
    int min=prices[0], res=0;
    for (int i=1; i<prices.length; i++) {
      min=Math.min(min, prices[i]);
      res=Math.max(res, prices[i]-min);
    }
    return res;
  }

  public int maxProfit_with1_dayCooldown(int[] prices) {
    int N = prices.length;
    if (N<2) return 0;
    int t0=0, t1=-prices[0], old = 0;
    for (int i=1; i<N; i++) {
      int temp = t0;
      t0 = Math.max(t0, t1 + prices[i]);
      t1 = Math.max(t1, old - prices[i]);
      old = temp;
    }
    return t0;
  }
}
