package com.google.bfs.dfs.dfs;

import java.util.Arrays;

public class LongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        int M=matrix.length, N=(M==0? 0 : matrix[0].length);
        if (M==0 || N==0) return 0;
        int res=1;
        boolean[][] visited = new boolean[M][N];
        int[][] dp = new int[M][N];
        Arrays.fill(dp, 1);
        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if (!visited[i][j]) {
                    res = Math.max(res,
                            dfs(matrix, i, j, M, N, Integer.MIN_VALUE, visited, dp));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] A, int i, int j, int M, int N, int prev,
                    boolean[][] visited, int[][ ] dp) {
        if (i<0 || j<0 || i==M || j==N || A[i][j]<=prev) return 0;
        if (visited[i][j]) return dp[i][j];
        visited[i][j]=true;
        int max = Math.max(Math.max(dfs(A, i-1, j, M, N, A[i][j], visited, dp),
                dfs(A, i+1, j, M, N, A[i][j], visited, dp)),
                Math.max(dfs(A, i, j-1, M, N, A[i][j], visited, dp),
                dfs(A, i, j+1, M, N, A[i][j], visited, dp)))+1;
        dp[i][j]=max;
        return max;
    }
}
