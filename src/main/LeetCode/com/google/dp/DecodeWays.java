package com.google.dp;

/**
 * Created by ychang on 3/9/2017. Must consider all corner cases, such as 010, 101, 110
 */
public class DecodeWays {
  public int numDecodings(String s) {
    if (s==null || s.length()==0 || s.charAt(0)=='0') return 0;
    int[] dp = new int[s.length()+1];
    dp[0]=dp[1]=1;
    for (int i=2; i<=s.length(); i++) {
      int v = Integer.parseInt(s.substring(i-2, i));
      if (s.charAt(i-1)=='0') {
        if (v==10 || v==20) dp[i]=dp[i-2];
        else return 0;
      } else {
        //if v<10, such as 01, it is not a valid decoded string, so dp[i-2] could be count.
        if (v>=10 && v<=26) dp[i]=dp[i-1]+dp[i-2];
        else dp[i]=dp[i-1];
      }
    }
    return dp[s.length()];
  }

  public int numDecodings_faster(String s) {
    if (s==null || s.length()==0 || s.charAt(0)=='0') return 0;
    /**
     * we only need 2 values, becasue for each dp[i], we only care dp[i-1] and dp[i-2]
     */
    int c0=1, c1=1;
    for (int i=2; i<=s.length(); i++) {
      int temp=0;
      if (s.charAt(i-1)!='0') temp=c1;
      int v = Integer.parseInt(s.substring(i-2, i));
      if (v<=26 && v>=1 && s.charAt(i-2)!='0') temp+=c0;
      c0=c1;
      c1=temp;
    }
    return c1;
  }
}
