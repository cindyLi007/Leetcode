package com.google.dp;

/**
 * 727. Minimum Window Subsequence
 * Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.
 *
 * If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple
 * such minimum-length windows, return the one with the left-most starting index.
 *
 * Example 1:
 *
 * Input:
 * S = "abcdebdde", T = "bde"
 * Output: "bcde"
 * Explanation:
 * "bcde" is the answer because it occurs before "bdde" which has the same length.
 * "deb" is not a smaller window because the elements of T in the window must occur in order.
 */

/**
 * dp[i][j] store the most right start index which can make S substring till i (inclusive) match T substring [0,j]
 * Time: O(N*M), Space: O(N*M)
 */
public class MinWindow {
  public static String minWindow(String S, String T) {
    int M = S.length(), N = T.length();
    if (M<=N) return S.equals(T) ? S : "";
    int[][] dp = new int[N][M];
    String res = "";

    // i is index of T, j is index of S
    for (int i=0; i<N; i++) {
      char t = T.charAt(i);
      for (int j=0; j<M; j++) {
        // if j < i, we could not match S subtring till i match T substring[0, j], so set it to -1
        if (j<i) dp[i][j]=-1;
        else {
          // if s[j]=t[i], we can directly use dp[i-1][j-1]
          if (S.charAt(j)==t) {
            dp[i][j] = i==0 ? j : dp[i-1][j-1];
            // render res substring
            if (i==N-1 && dp[i][j] >= 0) {
              int len = j-dp[i][j]+1;
              if (res.length()==0 || res.length() > len) {
                res = S.substring(dp[i][j], j+1);
              }
            }
          } else {
            // if s[j]!=t[i], that means s[j] is useless, just borrow it's previous char's starting index
            dp[i][j] = j==0 ? -1 : dp[i][j-1];
          }
        }
      }
    }

    return res;
  }

  // Time: O(N*M), Space: O(M)
  public String minWindow_oneDimensionDp(String S, String T) {
    int M = S.length(), N = T.length();
    if (M<=N) return S.equals(T) ? S : "";
    int[] dp = new int[M];
    String res = "";
    for (int i=0; i<N; i++) {
      char t = T.charAt(i);
      int prev = -1;
      for (int j=0; j<M; j++) {
        int temp = dp[j];
        if (j<i) dp[j]=-1;
        else {
          if (S.charAt(j)==t) {
            dp[j] = i==0 ? j : prev;
            if (i==N-1 && dp[j] >= 0) {
              int len = j-dp[j]+1;
              if (res.length()==0 || res.length() > len) {
                res = S.substring(dp[j], j+1);
              }
            }
          } else {
            dp[j] = j==0 ? -1 : dp[j-1];
          }
        }
        prev = temp;
      }
    }

    return res;
  }

  public static void main(String... args) {
    //System.out.println("result is " + minWindow("abcdebdde", "bde")); // bcde
    //System.out.println("result is " + minWindow("jmeqksfrsdcmsiwvaovztaqenprpvnbstl", "u")); // ""
    System.out.println("result is " + minWindow("nkzcnhczmccqouqadqtmjjzltgdzthm","bt")); // ""
  }
}
