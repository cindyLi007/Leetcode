package com.google.dp;

import java.util.Arrays;

public class UniquePath {
    // faster than use 2-d array
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        Arrays.fill(dp, 1);
        int left = 1;

        for (int i=1; i<m; i++) {
            // for each row, just use prev values as immediate top row
            for (int j=1; j<n; j++) {
                dp[j] += left;
                left = dp[j];
            }
            left = 1;
        }
        return dp[n-1];
    }
}
