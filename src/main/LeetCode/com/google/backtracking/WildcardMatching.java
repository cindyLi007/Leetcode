package com.google.backtracking;

/**
 * Created by ychang on 5/12/2017.
 * this can beat 97%
 */
public class WildcardMatching {
  /**
   * this can beat 83%
   */
  public boolean isMatch(String s, String p) {
    int sp = 0, pp = 0, lastStar = -1, firstBack = 0;
    while (sp<s.length()) {
      if (pp<p.length() && (s.charAt(sp)==p.charAt(pp) || p.charAt(pp)=='?')) {
        sp++;
        pp++;
      } else if (pp<p.length() && p.charAt(pp)=='*') {
        /** we need absorb as much as possible char in P, so first skip "*", but record its index for later backtrack;
         * if there are multiple "*", we only need the last one
        */
        lastStar = pp++;
        // firstBack is the index in S when later mismatch, backtrack from its next char
        firstBack = sp;
      } else if (lastStar!=-1) { // we can backtrack since we encounter a "*" before
        /** if mismatch happens, we need go back to last "*" in P and the char which first compare with the "*" in S.
         * We try to make "*" match as little as possible. So set pp to the next char to "*", and sp to next char
         * to 1st-char-compare-to-"*"
        */
        pp = lastStar + 1;
        sp = ++firstBack;
      } else
        return false;
    }
    while (pp<p.length()) {
      if (p.charAt(pp++)!='*')
        return false;
    }
    return true;
  }

  /**
   * this can beat 64%
   */
  public boolean isMatch_dp(String s, String p) {
    int sLen = s.length(), pLen = p.length();
    // dp[i][j] means whether s.substring(i) matches p.substring(j)
    boolean[][] dp = new boolean[sLen + 1][pLen + 1];
    dp[sLen][pLen] = true;
    for (int i = pLen - 1; i>=0; i--) {
      if (p.charAt(i)!='*')
        break;
      dp[sLen][i] = true; // dp[sLen][i] is whether p.substring(i) match empty string
    }
    for (int i = sLen - 1; i>=0; i--) {
      for (int j = pLen - 1; j>=0; j--) {
        if (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') {
          dp[i][j] = dp[i + 1][j + 1];
        } else if (p.charAt(j)=='*') {
          // if dp[i+1][j] is true, since '*' can matches any sequence of char,, dp[i][j] should be true;
          // if dp[i][j+1] is true, since '*' can matches empty sequence, dp[i][j] should be true;
          dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
        }
      }
    }
    return dp[0][0];
  }
}
