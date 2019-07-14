package com.google.dp;

/**
 * Leetcode 583
 */
public class DeleteOperationFor2Strings {
    // Time: O(N*M), Space: O(N*M)
    // similar with Edit distance
    public int minDistance(String word1, String word2) {
        int N=word1.length(), M=word2.length();
        int[][] dp = new int[N+1][M+1];
        for (int i=0; i<=N; i++) dp[i][0]=i;
        for (int j=0; j<=M; j++) dp[0][j]=j;
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1];
                } else {
                    dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                }
            }
        }
        return dp[N][M];
    }

    // use the longest common sequence, because we can delete any pos in the 2 strings, when find the LCS, just neec to
    // remove all chars which are not in LCS
    public int minDistance_LCS(String word1, String word2) {
        int N=word1.length(), M=word2.length();
        int[][] dp = new int[N+1][M+1];
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1]+1;
                } else {
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return N+M-2*dp[N][M];
    }
}
