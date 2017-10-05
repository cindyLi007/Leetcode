package com.google.bfs.dfs.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 4/24/2017.
 */
public class RemoveInvalidParentheses {
  public List<String> removeInvalidParentheses(String s) {
    List<String> ans = new ArrayList<>();
    remove(s, ans, 0, 0, new char[]{'(', ')'});
    return ans;
  }

  public void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
    for (int stack = 0, i = last_i; i < s.length(); ++i) {
      if (s.charAt(i) == par[0]) stack++;
      if (s.charAt(i) == par[1]) stack--;
      if (stack >= 0) continue;
      for (int j = last_j; j <= i; ++j)
        if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
          remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
      return;
    }
    String reversed = new StringBuilder(s).reverse().toString();
    if (par[0] == '(') // finished left to right
      remove(reversed, ans, 0, 0, new char[]{')', '('});
    else // finished right to left
      ans.add(reversed);
  }

  /**
   * this one is not correct, has duplicated string in result
   */
  public List<String> removeInvalidParentheses_mine(String s) {
    List<String> res = new LinkedList();
    remove(s, res, 0, new char[]{'(', ')'});
    remove(new StringBuilder(s).reverse().toString(), res, 0, new char[]{')', '('});
    return res;
  }
  /**
   * start is the index from which we begin to scan "(" and ")", that means substring[0, i-1] is valid
   */
  private void remove(String s, List<String> res, int start, char[] ch) {
    int count=0;
    for (int i=start; i<s.length(); i++) {
      char c = s.charAt(i);
      if (c==ch[0]) count++;
      else if (c==ch[1]) count--;
      if (count<0) {
        for (int j=start; j<=i; j++) {
          if (s.charAt(j)==ch[1] && (j==start || s.charAt(j-1)!=ch[1])) {
            remove(s.substring(0, j)+s.substring(j+1), res, i, ch);
          }
        }
        return;
      }
    }
    if (count==0) res.add(s);
  }
}