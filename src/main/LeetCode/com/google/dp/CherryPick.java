package com.google.dp;

public class CherryPick {
    public static int cherryPickup(int[][] grid) {
        int M = grid.length, N = M==0 ? 0 : grid[0].length;
        int[][] dp = new int[M][N];
        for (int i=0; i<M; i++) {
            dp[i][0] = grid[i][0]==1 ? 1 : 0;
        }
        for (int i=0; i<N; i++) {
            dp[0][i] = grid[0][i]==1 ? 1 : 0;
        }
        for (int i=1; i<M; i++) {
            for (int j=1; j<N; j++) {
                if (grid[i][j]==-1) dp[i][j]=0;
                else {
                    dp[i][j]=dp[i-1][j] + dp[i][j-1];
                    if (dp[i][j]!=0) dp[i][j]+=grid[i][j];
                }
            }
        }
        return dp[M-1][N-1];
    }

    public static void main(String... args) {
        int cherryPickup = cherryPickup(new int[][]{{1, 1, -1}, {1, -1, 1}, {-1, 1, 1}});
        System.out.println(cherryPickup);
    }
}
