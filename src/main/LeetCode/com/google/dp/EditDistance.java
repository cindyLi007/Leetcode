package com.google.dp;

import java.util.Arrays;

/**
 * Created by ychang on 5/3/2017.
 */
public class EditDistance {
  public int minDistance(String word1, String word2) {
    int lenS=word1.length(), lenT=word2.length();
    int[][] dp = new int[lenS+1][lenT+1];
    // initialize edge case
    for (int i=0; i<=lenS; i++) dp[i][0]=i;
    for (int i=0; i<=lenT; i++) dp[0][i]=i;
    for (int i=0; i<lenS; i++) {
      for (int j=0; j<lenT; j++) {
        int min=Math.min(dp[i][j], Math.min(dp[i+1][j], dp[i][j+1]));
        if (word1.charAt(i)==word2.charAt(j)) {
          dp[i+1][j+1]=dp[i][j];
        } else {
          dp[i+1][j+1]=min+1;
        }
      }
    }
    System.out.println(Arrays.deepToString(dp));
    return dp[lenS][lenT];
  }
}
