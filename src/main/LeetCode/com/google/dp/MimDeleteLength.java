package com.google.dp;

import java.util.Arrays;

// Leetcode
public class MimDeleteLength {

  // Time: O(N * L^2), Space: O(L)
  public int minDeletionSize(String[] A) {
    int N=A.length, L=A[0].length(), res=L-1;
    // dp[i] means till A[i] char, max non-descreasing subsequence
    int[] dp = new int[L];
    Arrays.fill(dp, 1);
    for (int i=1; i<L; i++) {
      for (int k=0; k<i; k++) {
        int j=0;
        for (; j<N; j++) {
          // if there is any string in Array A could not satisfy non-decreasing from char[k] to char[i], we will not consider k
          if (A[j].charAt(k)>A[j].charAt(i)) break;
        }
        if (j==N) {
          dp[i]=Math.max(dp[i], dp[k]+1);
        }
      }
      res = Math.min(res, L-dp[i]);
    }
    return res;
  }
}
