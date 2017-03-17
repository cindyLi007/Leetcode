package com.google.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by ychang on 3/8/2017.
 */
public class WordBreakII {

  // this one can beat 93%, it combines dfs and dp together, during dfs, save whether from position i, we can render a result
  public List<String> wordBreak_best(String s, List<String> wordDict) {
    Set<String> dict = new HashSet(wordDict);
    List<String> res = new LinkedList();
    boolean[] dp = new boolean[s.length() + 1];
    /**
     must first set all 0 to len all dp entries true, so we can go deep if we did not check this position
     */
    Arrays.fill(dp, true);

    dfs(s, dict, res, dp, "", 0);
    return res;
  }

  private boolean dfs(String s, Set<String> dict, List<String> res, boolean[] dp, String prefix, int start) {
    if (start==s.length()) {
      res.add(prefix.trim());
    } else {
      boolean temp = false;
      for (int i = start + 1; i<=s.length(); i++) {
        if (dp[i] && dict.contains(s.substring(start, i))) {
          if (dfs(s, dict, res, dp, prefix + " " + s.substring(start, i), i))
            temp = true;
        }
      }
      if (!temp)
        dp[start] = temp;
    }
    return dp[start];
  }

  // this one can beat 40%, because it need 2 round and save prev step in dp
  public List<String> wordBreak(String s, List<String> wordDict) {
    List<String> res = new LinkedList();
    Set<String> dict = new HashSet(wordDict);
    List<Integer>[] dp = (LinkedList<Integer>[]) new LinkedList[s.length() + 1];
    /**
     * here we could not use Arrays.fill(dp, new LinkedList()), that will make all array items point to one single list
     */
    for (int i = 0; i<=s.length(); i++) {
      dp[i] = new LinkedList();
    }
    dp[0].add(0);

    for (int i = 1; i<=s.length(); i++) {
      for (int j = 0; j<i; j++) {
        /**
         * dp[j] is not empty means in j, there is a word solutions, all word solutions will end in dp[0], so make dp[0]=0
         */
        if (!dp[j].isEmpty() && dict.contains(s.substring(j, i))) {
          dp[i].add(j);
        }
      }
    }
    if (dp[s.length()].isEmpty())
      return res;
    // backtrack all solutions
    dfs("", res, s, dp, s.length());
    return res;
  }

  private void dfs(String sb, List<String> res, String s, List<Integer>[] dp, int next) {
    if (next==0) {
      res.add(sb.trim());
    } else {
      List<Integer> list = dp[next];
      for (int i : list) {
        dfs(s.substring(i, next) + " " + sb, res, s, dp, i);
      }
    }
  }
}
