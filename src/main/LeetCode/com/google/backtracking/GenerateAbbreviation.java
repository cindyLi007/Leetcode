package com.google.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ychang on 3/30/2017.
 */
public class GenerateAbbreviation {
  public List<String> generateAbbreviations(String word) {
    List<String> res = new ArrayList();
    /** use char array and StringBuilder can improve performance, we just need notice StringBuilder is NOT immutable class,
     * so when we pass it to next level, we change the same StringBuilder instance, so we need set it back
     */
    dfs(word.toCharArray(), res, new StringBuilder(), 0, 0);
    return res;
  }

  private void dfs(char[] word, List<String> list, StringBuilder str, int pos, int count) {
    int len = str.length();
    if (pos==word.length)
      list.add(str.append(count>0 ? count : "").toString());
    else {
      dfs(word, list, str, pos + 1, count + 1); // abbreviation, we will not append count_bruteForce or char to str
      // not abbreviation, so we need append prev count_bruteForce, and current char, and we need reset count_bruteForce to 0
      dfs(word, list, str.append(count>0 ? count : "").append(word[pos]), pos + 1, 0);
    }
    str.setLength(len);
  }

}
