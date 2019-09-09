package com.google.dp;

import java.util.Arrays;

/**
 * Created by ychang on 5/3/2017.
 */
public class EditDistance {
  /*public int minDistance(String word1, String word2) {
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
  }*/

  public int minDistance(String word1, String word2) {
    int len1=word1.length(), len2=word2.length();
    int[][] dp = new int[len1][len2];
    for (int[] row : dp) Arrays.fill(row, -1);
    return dist(word1, len1-1, word2, len2-1, dp);
  }

  private int dist(String A, int idx1, String B, int idx2, int[][] dp) {
    if (idx1<0) return idx2+1; // insert (idx2+1) chars in A
    if (idx2<0) return idx1+1; // remove (idx1+1) chars in A
    if (dp[idx1][idx2]==-1) {
      if (A.charAt(idx1)==B.charAt(idx2)) {
        return dist(A, idx1-1, B, idx2-1, dp);
      } else {
        int replace = dist(A, idx1-1, B, idx2-1, dp);
        int delete = dist(A, idx1-1, B, idx2, dp);
        int insert = dist(A, idx1, B, idx2-1, dp);
        dp[idx1][idx2] = Math.min(replace, Math.min(delete, insert));
      }
    }
    return dp[idx1][idx2];
  }

  public int minDistance_spaceON(String word1, String word2) {
    int N=word1.length(), M=word2.length();
    if (N==0) return M; // add M char to word1;
    if (M==0) return N; // delete M char from word1;
    int[] dp = new int[N+1];
    for (int i=0; i<=N; i++) dp[i] = i; // delete i char to cover to word2

    for (int i=1; i<=M; i++) {
      int prev = dp[0];
      dp[0]=i;
      for (int j=1; j<=N; j++) {
        int temp = dp[j];
        if (word1.charAt(j-1) == word2.charAt(i-1)) {
          dp[j] = prev;
        } else {
          int replace = prev;
          int insert = dp[j-1];
          int delete = dp[j];
          dp[j] = Math.min(Math.min(replace, insert), delete) + 1;
        }
        prev = temp;
      }
    }
    return dp[N];
  }
}
