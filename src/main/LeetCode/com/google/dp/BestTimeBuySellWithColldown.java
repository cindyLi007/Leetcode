package com.google.dp;

/**
 * Created by ychang on 3/9/2017.
 */
public class BestTimeBuySellWithColldown {
    // Time: O(N), Space: O(N)
    public int maxProfit(int[] prices) {
        int N = prices.length;
        if (N <= 1) return 0;
        // buy and sell present the maxProfit which end-by buy or sell at i-th day, buy or sell not neccesarily happened
        // at i-th day
        int[] buy = new int[N], sell = new int[N];
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i < N; i++) {
            if (i == 1) buy[i] = Math.max(buy[i - 1], -prices[i]);
            else buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[N - 1];
    }
}
