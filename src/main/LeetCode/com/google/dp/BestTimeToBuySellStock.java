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
}
