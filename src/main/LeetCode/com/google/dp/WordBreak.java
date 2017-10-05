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
      /**
       * j from i to 0 is faster than from 0 to i, that is because dp[bigger one} is a combination of of N dp[smaller one]
       * for dp[bigger one], we only need consider one word, from [j, i+1)
       */
      for (int j = i; j>=0 && !dp[i + 1]; j--) {
        if (dp[j] && dict.contains(s.substring(j, i + 1)))
          dp[i + 1] = true;
      }
    }
    return dp[s.length()];
  }
}
