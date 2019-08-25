package com.google.array;

public class BestTimeBuySellStockIII {
    public int maxProfit(int[] prices) {
        int firstMaxProfit = 0, secondMaxProfit = 0;
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int price : prices) {
            firstMin = Math.min(price, firstMin);
            // we need accumulate the first profit to this price
            // for ex. 3, 9, 8, 15, when we go item 8, this value is 2,
            // so when we go 15, we know the secondMaxProfit is 13
            // buy 2nd time in this price, we need also consider till this price, which is the max profit for the
            // 1st-time-buy-and-sell, so we can treat the 2nd-time-buy-and-sell as a single buy-and-sell buy
            // add the 1st time profit
            secondMin = Math.min(secondMin, price - firstMaxProfit);
            firstMaxProfit = Math.max(firstMaxProfit, price - firstMin);
            secondMaxProfit= Math.max(secondMaxProfit, price - secondMin);
        }
        return secondMaxProfit;
    }
}
