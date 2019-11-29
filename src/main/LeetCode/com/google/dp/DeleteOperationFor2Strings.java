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

    // use the longest common sequence, because we can delete any pos in the 2 strings, when find the LCS, just need to
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

    public static int minDistance_oneDArray(String word1, String word2) {
        int M = word1.length(), N = word2.length();
        if (M==0 || N==0) return Math.max(M, N);
        int[] dp = new int[N+1];
        for (int i=1; i<=N; i++) dp[i] = i;
        for (int i=0; i<M; i++) {
            int prev = dp[0];
            dp[0]=i+1;
            for (int j=0; j<N; j++) {
                int temp = dp[j+1];
                if (word1.charAt(i)==word2.charAt(j)) {
                    dp[j+1] = prev;
                } else {
                    dp[j+1] = Math.min(dp[j+1], dp[j]) + 1;
                }
                prev = temp;
            }
        }
        return dp[N];
    }

    public static void main(String... args) {
        System.out.println(minDistance_oneDArray("sea", "eat"));
        System.out.println(minDistance_oneDArray("a", "e"));
    }

}
