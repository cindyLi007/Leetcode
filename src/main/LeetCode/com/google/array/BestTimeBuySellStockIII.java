package com.google.array;

public class BestTimeBuySellStockIII {

    // Leetcode 123 Time: O(N), can have at most 2 transactions
    public int maxProfit(int[] prices) {
        int N = prices.length;
        if (N<2) return 0;

        // t0_0 means 0 transaction and 0 stock in hand AFTER this day
        // t1_0 means 1 transaction(transaction counts when buy) and 0 stock in hand AFTER this day, for 1st day, that means no buy
        // t2_0 means 2 transaction and 0 stock in hand AFTER this day
        // t1_1 means 1 transaction and 1 stock in hand AFTER this day, for 1st day, that mean buy
        // t2_1 means 2 transaction and 1 stock in hand AFTER this day

        int t0_0=0, t1_0=0, t2_0=0, t1_1=-prices[0], t2_1=-prices[0];
        for (int i=1; i<N; i++) {
            // PAY ATTENTION for order, only t1_1 depends on t0_0 which is an inviant var
            t2_0=Math.max(t2_0, t2_1 + prices[i]);
            t2_1=Math.max(t2_1, t1_0 - prices[i]);
            t1_0=Math.max(t1_0, t1_1 + prices[i]);
            t1_1=Math.max(t1_1, t0_0 - prices[i]);
        }
        return t2_0;
    }
}
