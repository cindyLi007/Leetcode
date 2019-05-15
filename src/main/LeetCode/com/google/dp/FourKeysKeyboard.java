package com.google.dp;

import static com.google.dp.FourKeysKeyboard.maxA;

public class FourKeysKeyboard {
    // Time: O(N^2), Space: O(N)
    public static int maxA(int N) {
        int[] dp = new int[N+1];
        dp[0]=0;
        dp[1]=1;
        for (int i=2; i<=N; i++) {
            int res = i;
            // the reason till i-3 is Ctrl + A, Ctrl + C, Ctrl + V is 3 times
            for (int j=1; j<=i-3; j++) {
                // when j==i-3, double
                res = Math.max(res, dp[j] * (i-j-1));
            }
            dp[i]=res;
        }
        return dp[N];
    }

    public static void main(String[] args) {
        int maxA = FourKeysKeyboard.maxA(10);
        System.out.println(maxA);
    }
}
