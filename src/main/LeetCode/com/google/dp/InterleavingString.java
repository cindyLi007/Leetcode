package com.google.dp;

import java.util.ArrayList;
import java.util.List;

public class InterleavingString {
  // Time: O(N2* N1)
  public static boolean isInterleave(String s1, String s2, String s3) {
    int N1 = s1.length(), N2 = s2.length(), N3 = s3.length();
    if (N1+N2!=N3) return false;
    boolean[][] dp = new boolean[N1+1][N2+1];
    dp[0][0]=true;
    for (int i=0; i<N1 && dp[i][0]; i++) dp[i+1][0] = s1.charAt(i)==s3.charAt(i);
    for (int i=0; i<N2 && dp[0][i]; i++) dp[0][i+1] = s2.charAt(i)==s3.charAt(i);
    for (int i=0; i<N1; i++) {
      for (int j=0; j<N2; j++) {
        dp[i+1][j+1] = dp[i][j+1] && s1.charAt(i) == s3.charAt(i+j+1) ||
            dp[i+1][j] && s2.charAt(j) == s3.charAt(i+j+1);
      }
    }
    return dp[N1][N2];
  }

  public static void main(String... args) {
    System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
  }

}
