package com.google.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnightDialer {
    private final int M = (int)1e9+7;

    public int knightDialer_recursive(int N) {
        if (N==0) return 0;
        if (N==1) return 10;
        int count=0;
        int[][] dp = new int[10][N];
        // NOTICE: no need to keep all sub array same length, that is an advantage of define all members when initialize it
        int[][] map = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8},
                {3, 0, 9}, {}, {7, 1, 0}, {6, 2}, {1, 3}, {2, 4}};

        // from N==1, begin hop, and for each of them, we can hop to how many? use neighbor to compute
        for (int i=0; i<=9; i++) {
            count = (count + helper(i, N-1, dp, map)) % M;
        }
        return count;
    }

    private int helper(int start, int N, int[][] dp, int[][] map) {
        if (N==0) return 1;
        if (dp[start][N]!=0) return dp[start][N];

        int count=0;
        int[] neighbors = map[start];

        for (int n : neighbors) {
            count = (count+helper(n, N-1, dp, map)) % M;
        }
        dp[start][N]=count;
        return count;
    }

    // Time: O(N*10*3) liner
    public int knightDialer(int N) {
        if (N==0) return 0;
        if (N==1) return 10;
        int count=0;
        int[][] dp = new int[N+1][10];
        int[][] map = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8},
                {3, 0, 9}, {}, {7, 1, 0}, {6, 2}, {1, 3}, {2, 4}};

        Arrays.fill(dp[1], 1);
        for (int i=2; i<=N; i++) {
            for (int j=0; j<=9; j++) {
                int[] neighbors = map[j];
                for (int next : neighbors) {
                    dp[i][next] = (dp[i][next] + dp[i-1][j]) % M;
                }
            }
        }

        for (int i=0; i<=9; i++) {
            count = (count+dp[N][i]) % M;
        }

        return count;
    }

    public static void main(String... args) {
        KnightDialer knightDialer = new KnightDialer();
        System.out.println(knightDialer.knightDialer(1));
        System.out.println(knightDialer.knightDialer(2));
        System.out.println(knightDialer.knightDialer(3));
    }
}
