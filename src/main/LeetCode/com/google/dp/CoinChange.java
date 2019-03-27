package com.google.dp;

import java.util.Arrays;

public class CoinChange {
    // Time: O(N*L), N is the amount length, L is the length of coins, Space: O(N)
    public int coinChange(int[] coins, int amount) {
        /* For idx i, the answer is dp[amount-coins[i]] + 1 */

        int[] dp = new int[amount+1];
        dp[0]=0;
        // this sort is necessary, L*lgL
        Arrays.sort(coins);
        for (int i=1; i<=amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j=0; j<coins.length && coins[j]<=i; j++) {
                if (dp[i-coins[j]] != Integer.MAX_VALUE) {
                    dp[i]=Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }

        return dp[amount]==Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
