package com.google.dp;

public class MinCostToMergeStones {

  // Time: O(N*N*(N/K)), Space: O(N*N)
  public static int mergeStones(int[] stones, int K) {
    int N = stones.length;
    if ((N-1)%(K-1)!=0) return -1;

    // dp[i][j] stores from i to j if can merge, what is the min cost, if (Len(j, i)-1)%(K-1) == 0 that means it can merge to 1 pile, otherwise, we only calculate
    // (from i(start point) to the farest point which can finally merge to 1 pile)'s merge cost
    int[][] dp = new int[N][N];

    int[] sum = new int[N+1];
    for (int i=0; i<N; i++) sum[i+1] = sum[i]+stones[i];

    for (int L=K; L<=N; L++) { // L is the length of small range
      for (int i=0; i<=N-L; i++) {
        int j=i+L-1;
        dp[i][j]=Integer.MAX_VALUE;

        // each time we need keep from i to m is a "can-merge-to-one-pile" piles set, so m step is K-1; because each time besides i, we add(K-1) to the piles
        for (int m=i; m+1<=j; m+=K-1) {
          dp[i][j]=Math.min(dp[i][j], dp[i][m] + dp[m+1][j]);
        }
        if ((j-i)%(K-1)==0) {
          dp[i][j]+=sum[j+1] - sum[i]; // if [i, j] can merge to 1 pile, we need finally add each elem from i to j
        }
      }
    }

    return dp[0][N-1];
  }

  public static void main(String... args) {
    int m = mergeStones(new int[]{3, 5, 1, 2, 6}, 3);
    System.out.println(m);
  }
}
