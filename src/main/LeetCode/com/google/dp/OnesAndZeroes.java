package com.google.dp;

public class OnesAndZeroes {
  public int findMaxForm(String[] strs, int m, int n) {
    // dp[i][j] denotes if there are i 0 and j 1, what is the max strings we can form
    int[][] dp = new int[m + 1][n + 1];
    for (String s : strs) {
      int oneBits = process(s);
      int zeroBits = s.length() - oneBits;

      // now we know for string s, how many one bits and how many zero bits
      // 必须从大到小，因为这样才能保证小的数dp[i-zeroBits][j-oneBits] 没有包括String s.
      // 如果我们从小到大的来做 后面的dp entry用的是前面计算出来的结果 有可能已经包括这个str 了
      for (int i = m; i >= zeroBits; i--) {
        for (int j = n; j >= oneBits; j--) {
          // we can ignore current string, or use it if we have plenty bits
          dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeroBits][j - oneBits]);
        }
      }
    }
    return dp[m][n];
  }

  private int process(String s) {
    int count = 0;
    char[] ch = s.toCharArray();
    for (char c : ch) {
      if (c == '1') count++;
    }
    return count;
  }

  public static void main(String... args) {
    OnesAndZeroes onesAndZeroes = new OnesAndZeroes();
    int maxForm = onesAndZeroes.findMaxForm(new String[]{"10", "0001", "111001", "0", "1"}, 5, 3);
    System.out.println(maxForm);
  }
}
