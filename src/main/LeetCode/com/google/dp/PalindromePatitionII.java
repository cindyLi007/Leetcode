package com.google.dp;

public class PalindromePatitionII {
    // Must cache the isPalindrome result to improve performance
    boolean[][] p;

    // Time: O(N*N), Space: O(N*N)
    public int minCut(String s) {
        if (s==null || s.length()<=1) return 0;
        int len = s.length();
        int[] dp = new int[len];
        for (int i=0; i<len; i++) dp[i]=i;
        p = new boolean[len][len];

        for (int i=1; i<len; i++) {
            for (int j=0; j<=i; j++) {
                if (isPalin(s, j, i)) {
                    dp[i] = Math.min(dp[i], j==0 ? 0 : dp[j-1] + 1);
                }
            }
        }

        return dp[len-1];
    }

    private boolean isPalin(String s, int start, int end) {
        if (s.charAt(start) == s.charAt(end) && (end-start<=1 || p[start+1][end-1])) {
            p[start][end]=true;
            return true;
        }
        return false;
    }
}
