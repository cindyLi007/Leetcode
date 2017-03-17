package com.google.dp;

/**
 * Created by ychang on 3/9/2017.
 * Refer http://www.cnblogs.com/grandyang/p/4299608.html
 * C(0)=1 and C(n+1)=Sum(C(i)*C(n-i)) where i=0, 1, 2 to n
 * Refer https://discuss.leetcode.com/topic/8398/dp-solution-in-6-lines-with-explanation-f-i-n-g-i-1-g-n-i
 */
public class UniqueBST {
  public int numTrees(int n) {
    int[] dp = new int[n+1];
    dp[0]=1;
    dp[1]=1;
    for (int i=2; i<=n; i++) {
      for (int j=0; j<i; j++) {
        dp[i]+=dp[j]*dp[i-1-j];
      }
    }
    return dp[n];
  }
}
