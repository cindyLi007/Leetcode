package com.google.dp;

public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String s : strs) {
            int oneBits = process(Integer.parseInt(s, 2));
            int zeroBits = s.length() - oneBits;

            for (int i = m; i >= zeroBits; i--) {
                for (int j = n; j >= oneBits; j--) {
                    dp[i][j] = Math.max(dp[i-zeroBits][j-oneBits]+1, dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

    private int process(int x) {
        int count=0;
        while (x!=0) {
            count++;
            x = x & (x-1);
        }
        return count;
    }

    public static void main(String... args) {
        OnesAndZeroes onesAndZeroes = new OnesAndZeroes();
        int maxForm = onesAndZeroes.findMaxForm(new String[]{"10", "0001", "111001", "0", "1"}, 5, 3);
        System.out.println(maxForm);
    }
}
