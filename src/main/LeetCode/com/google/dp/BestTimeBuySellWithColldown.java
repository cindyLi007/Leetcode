package com.google.dp;

/**
 * Created by ychang on 3/9/2017.
 */
public class BestTimeBuySellWithColldown {
  public int maxProfit(int[] prices) {
    if (prices==null || prices.length<=1)
      return 0;
    int dp[] = new int[prices.length];
    dp[0] = 0;
    int min = 0;
    for (int i = 1; i<prices.length; i++) {
      int temp = 0;
      if (prices[i]>prices[min])
        temp = prices[i] - prices[min];
      else
        min = prices[i]< prices[min] ? i : min;
      dp[i] = temp + (temp==0 ? dp[i - 1] : 0);
      if (temp!=0 && min - 2>0)
        dp[i] += dp[min - 2];
      dp[i]=Math.max(dp[i], dp[i-1]);
    }
    return dp[prices.length - 1];
  }
}
