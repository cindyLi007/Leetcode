package com.google.bfs.dfs;

import java.util.ArrayList;
import java.util.List;

/*
1. first think about the basic algorithm, should use recursive, for each round of recursive, try different number and for each
   number try different operators. Pass prefix and value to next round, and when run out of the num string, check whether value == target
2. need consider * is higher than + and -, how to handle that case? we need pass an extra val which is left number if next operation is "*"
   but we still need record current res.
3. corner case: could not have more than 1 zero in the begining, if is starts with 0, must only 0.
 */
public class ExpressionAddOperator {
  int N;
  // Time: O(N*3^N), the front N is for each recurisive how to extract the substring, Space: O(N)
  public List<String> addOperators(String num, int target) {
    List<String> res = new ArrayList();
    if (num==null || num.length()==0) return res;
    N = num.length();
    helper(num, 0, 0, 0, "", target, res);
    return res;
  }

  private void helper(String num, int start, long eval, long mulVal, String prefix, int target, List<String> res) {
    if (start==N) {
      if (eval == target) res.add(prefix);
    } else {
      int end = num.charAt(start)=='0' ? start+1 : N;
      for (int i=start+1; i<=end; i++) {
        String s = num.substring(start, i);
        long v = Long.parseLong(s);
        if (start==0) helper(num, i, v, v, ""+v, target, res);
        else {
          helper(num, i, eval + v, v, prefix + "+" + v, target, res);
          helper(num, i, eval - v, -v, prefix + "-" + v, target, res);
          helper(num, i, eval-mulVal + mulVal*v, mulVal*v, prefix + "*" + v, target, res);
        }
      }
    }
  }
}
