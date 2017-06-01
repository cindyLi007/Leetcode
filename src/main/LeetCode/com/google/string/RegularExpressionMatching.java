package com.google.string;

/**
 * Created by ychang on 5/2/2017.
 */
public class RegularExpressionMatching {
  public boolean isMatch(String s, String p) {
    // base case
    if (p.length()==0)
      return s.length()==0;
    // if p.charAt(1) is not *, we can move forward p
    if (p.length()==1 || p.charAt(1)!='*') {
      if (s.length()>0 && (p.charAt(0)==s.charAt(0) || p.charAt(0)=='.'))
        return isMatch(s.substring(1), p.substring(1));
      else
        return false;
    } else {
      if (s.length()>0 && (p.charAt(0)==s.charAt(0) || p.charAt(0)=='.')) {
        /**
         * please notice, there're only 2 cases: move forward s, or move forward p, not have case isMatch(s.substring(1),
         * p.substring(2)). The reason we need NOT and should NOT include it is we can include it in sub call of
         * isMatch(s.substring(1), p) (it will have [s.sub(1), p.sub(2)]) include it will introduce TLE.
         */
        return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
      }
      return isMatch(s, p.substring(2));
    }
  }

  /**
   * this can beat 94%
   */
  public boolean isMatch_dp(String s, String p) {
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;
    // initialize dp
    for (int i = 0; i<p.length(); i++) {
      /**
       * dp[0][i+1] mean whether p.substring(0, i+1) match "", since * Matches zero or more of the preceding element,
       * here is zero preceding element, so dp[0][i+1] only depends on dp[0][i-1];
       */
      if (p.charAt(i)=='*' && dp[0][i - 1])
        dp[0][i + 1] = true;
    }
    for (int i = 0; i<s.length(); i++) {
      for (int j = 0; j<p.length(); j++) {
        if (p.charAt(j)==s.charAt(i) || p.charAt(j)=='.') {
          dp[i + 1][j + 1] = dp[i][j];
        } else {
          if (p.charAt(j)=='*') {
            if (p.charAt(j - 1)==s.charAt(i) || p.charAt(j - 1)=='.') {
              dp[i + 1][j + 1] = dp[i + 1][j] || //we count a* as single one, because we ignore '*'
                  dp[i + 1][j - 1] || // we count a* as empty, because we ignore 'a*'
                  dp[i][j + 1]; // we count a* as multiple one, because we count a* to previous char in s
            } else {
              dp[i + 1][j + 1] = dp[i + 1][j - 1];
            }
          }
        }
      }
    }
    return dp[s.length()][p.length()];
  }
}
