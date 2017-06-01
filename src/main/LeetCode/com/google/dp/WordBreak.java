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
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 0; i<s.length(); i++) {
      for (int j = 0; j<=i && !dp[i + 1]; j++) {
        if (dp[j] && wordDict.contains(s.substring(j, i + 1)))
          dp[i + 1] = true;
      }
    }
    return dp[s.length()];
  }
}
