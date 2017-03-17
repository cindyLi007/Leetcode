package com.google.array;

/**
 * Created by ychang on 3/10/2017.
 * This problem we need NOT consider min transactions, so we can buy, sell and buy in same day, sell
 * such as [3, 5, 9], buy 3, sell 5 and buy 5, sell 9, maxProfit is 6, equals buy 3 and sell 9.
 * So makes it easy, just need loop one time. anytime keep min as buy price, whenever find a higher price, sell it and
 * reset min, keep going on.
 */
public class BestTimeBuySellStockII {
  public int maxProfit(int[] prices) {
    if (prices==null || prices.length==0) return 0;
    int res=0, min=prices[0];
    for (int i=0; i<prices.length; i++) {
      if (prices[i]>min) {
        res+=prices[i]-min;
        min=prices[i];
      } else {
        min=prices[i];
      }
    }
    return res;
  }

  /**
   * we need not keep min, because if i<i+1, we add diff to res, otherwise keep going on, that means when we find a i<i+1
   * now, i is the min.
   */
  public int maxProfit_simplified(int[] prices) {
    if (prices==null || prices.length==0) return 0;
    int res=0;
    for (int i=0; i<prices.length-1; i++) {
      if (prices[i]<prices[i+1]) {
        res+=prices[i+1]-prices[i];
      }
    }
    return res;
  }
}
