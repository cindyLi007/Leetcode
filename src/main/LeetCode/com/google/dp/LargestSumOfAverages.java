package com.google.dp;

/*
Leetcode 813
 */
public class LargestSumOfAverages {
  int N;

  // Time: O(N*N*K), Space: O(N*K)
  public double largestSumOfAverages(int[] A, int K) {
    N = A.length;
    // dp[i][j] denotes till i-th element in A (inclusive), if split to j group,
    // max score, when j==1, that means we average all elements in the group
    double[][] dp = new double[N][K+1];
    double sum = 0.0;
    for (int i=0; i<N; i++) {
      sum += A[i];
      dp[i][1] = sum/(i+1);
    }
    return compute(A, K, dp, N-1);
  }

  private double compute(int[] a, int k, double[][] dp, int idx) {
    if (k>idx+1) return 0;
    if (dp[idx][k]!=0) return dp[idx][k];
    double sum = a[idx];
    // we compute the max score for subarray[0, idx] and split to k group, it should the max value of split
    // subarray [0, i] to k-1 groups, plus average of last group [i+1, idx], we loop from right to left, because that is
    // eaier to compute sum
    for (int i=idx-1; i>=0; i--) {
      dp[idx][k] = Math.max(dp[idx][k],
          compute(a, k-1, dp, i) + sum/(idx-i));
      sum += a[i];
    }
    return dp[idx][k];
  }

  public static void main(String... args) {
    LargestSumOfAverages largestSumOfAverages = new LargestSumOfAverages();
    double v = largestSumOfAverages.largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3);
    System.out.println(v);
  }
}
