package com.google.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ychang on 3/8/2017.
 */
public class WordBreak {
  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> dict = new HashSet(wordDict);
    boolean[] dp = new boolean[s.length()+1];
    dp[0]=true;
    for (int i=1; i<=s.length(); i++) {
      for (int j=0; j<i; j++) {
        // when j==0, we check whether char(0 to i-1) which is s.substring(0, i) is in dict
        if (dp[j] && dict.contains(s.substring(j, i))) {
          dp[i]=true;
          break;
        }
      }
    }
    return dp[s.length()];
  }
}
