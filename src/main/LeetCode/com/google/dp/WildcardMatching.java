package com.google.dp;

/**
 * Created by ychang on 5/12/2017.
 * this can beat 60%
 */
public class WildcardMatching {
  public boolean isMatch(String s, String p) {
    int len1 = s.length(), len2 = p.length();
    boolean[][] dp = new boolean[len1 + 1][len2 + 1];
    /**
     * initial dp, we need consider first char or (first char sequence) is "*", there it can match empty string ""
     * which mean dp[0][1], dp[0][2]
     */
    dp[0][0] = true;
    int i = 0;
    while (i<len2 && p.charAt(i)=='*')
      dp[0][++i] = true;

    for (i = 0; i<len1; i++) {
      for (int j = 0; j<len2; j++) {
        /**
         * if S[i]=p[j], dp[i+1][j+1] depends on dp[i][j]
         */
        if (dp[i][j] && (p.charAt(j)==s.charAt(i) || p.charAt(j)=='?'))
          dp[i + 1][j + 1] = true;
        /**
         * if p[j] is "*" which means match 0 or multiple char sequence, if s[i-1] match p[j] or s[i] match p[j-1],
         * s[i] match p[j]. for example, s(abcde), p(ab(c)*cde), which hit *, we only ab match ab*, ab* can include one more
         * char from s, if abc match abc, abc* can match abc
         */
        else if (p.charAt(j)=='*')
          dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j];
      }
    }
    return dp[len1][len2];
  }

  /**
   * Since it is recursive, it is slow and could not pass big data test case (TLE), but the idea is very similar with
   * RegExp matching.
   */
  public boolean isMatch_recursive(String s, String p) {
    return isMatch(s.toCharArray(), p.toCharArray(), 0, 0);
  }

  private boolean isMatch(char[] s, char[] p, int i, int j) {
    if (j==p.length)
      return i==s.length;
    if (i<s.length && (p[j]==s[i] || p[j]=='?')) {
      return isMatch(s, p, i + 1, j + 1);
    } else if (p[j]=='*') {
      while (j<p.length - 1 && p[j + 1]=='*')
        j++; // make j hit to last *
      /**
       * since * can conclude as many as possible chars, from i start to skip *, check whether can match remaining,
       * if can't match, make * conclude that char, from the next char to check match
       */
      while (i<=s.length) { // should include ==, because j maybe the last char in P, it can match till last char in S
        if (isMatch(s, p, i, j + 1))
          return true;
        i++;
      }
      return false;
    }
    return false;
  }
}
