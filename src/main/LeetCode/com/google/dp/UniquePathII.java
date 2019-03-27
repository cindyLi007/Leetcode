package com.google.dp;

public class UniquePathII {
    // Time: O(N*M)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length, n=obstacleGrid[0].length;
        int[] dp=new int[n];
        if (obstacleGrid[0][0]==1) return 0;
        dp[0]=1;
        for (int j=1; j<n; j++) {
            dp[j] = (obstacleGrid[0][j]==1 || dp[j-1]==0) ? 0 : 1;
        }
        int left = 0;
        for (int i=1; i<m; i++) {
            left = 0;
            // must j from 0, because we do not know whether to dp[i][0] ==1
            for (int j=0; j<n; j++) {
                dp[j] = (obstacleGrid[i][j] == 1) ? 0 : dp[j] + left;
                left = dp[j];
            }

        }
        return dp[n-1];
    }
}
