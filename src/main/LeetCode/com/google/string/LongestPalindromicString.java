package com.google.string;

/**
 * Created by ychang on 3/14/2017.
 */
public class LongestPalindromicString {
  int start, max;

  /**
   * this one can beat 80%, O(n*n)
   */
  public String longestPalindrome(String s) {
    if (s.length()<=1) return s;
    start=0;
    max=1;
    for (int i=0; i<s.length()-1; i++) {
      /**
       * we need consider odd and even 2 cases for each i
       */
      search(s, i, i+1);
      search(s, i, i); // odd
    }
    return s.substring(start, start+max);
  }

  private void search(String s, int left, int right) {
    // please notice add s.charAt(left)==s.charAt(right) in while, otherwise will introduce dead loop
    while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
      left--;
      right++;
    }
    if (right-left-1 > max) {
      start=left+1;
      max=right-left-1;
    }
  }

  /**
   * this can beat 9%, the idea is dp[i][j] is whether from i to j is a Palindrome. dp[i][j]=char(i)==char(j) && dp[i+1][j-1]
   * so we know for i we should from len-1 to 0, and j should from i to len-1
  */
  public String longestPalindrome_dp(String s) {
    int len = s.length();
    if (len<=1) return s;
    boolean[][] dp = new boolean[len][len];
    String res = s.substring(0, 1);
    for (int i=len-1; i>=0; i--) {
      for (int j=i; j<len; j++) {
        if (i==j) dp[i][j]=true;
        else {
          dp[i][j]= s.charAt(i)==s.charAt(j) && (j-i<=2 || dp[i+1][j-1]);
          if (dp[i][j] && j-i+1>res.length()) {
            res=s.substring(i, j+1);
          }
        }
      }
    }
    return res;
  }
}
