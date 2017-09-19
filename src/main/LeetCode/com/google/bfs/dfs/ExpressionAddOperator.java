package com.google.bfs.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ychang on 4/29/2017.
 */
public class ExpressionAddOperator {
  public List<String> addOperators(String num, int target) {
    List<String> res = new ArrayList();
    if (num==null || num.length()==0) return res;
    /**
     * if the first char is 0, we can only set first operator to 0, not 03
    */
    int end = num.charAt(0)=='0' ? 1 : num.length();
    for (int i=1; i<=end; i++) {
      /** use long instead of int to prevent overflow
       */
      dfs(num, target, i, Long.parseLong(num.substring(0, i)), num.substring(0, i), res, Long.parseLong(num.substring(0, i)));
    }
    return res;
  }

  /**
   * @param diff record so far multiplied value. for example, 5+2*3*4, diff is 24, val is 29, if next operation is + or -
   *             use 29, if next operation is multiply, val should deduct diff, then add (diff*next), such as 29-24 + 24*2
   *             5+48 (5+2*3*4*2).
   */
  private void dfs(String num, int target, int index, long val, String path, List<String> res, long diff) {
    if (index==num.length()) {
      if (val==target) res.add(path);
    } else {
      int end = num.charAt(index)=='0' ? index+1 : num.length();
      for (int i=index+1; i<=end; i++) {
        String number = num.substring(index, i);
        long curVal = Long.parseLong(number);
        dfs(num, target, i, val+curVal, path+"+"+ number, res, curVal);
        dfs(num, target, i, val-curVal, path+"-"+ number, res, -curVal);
        dfs(num, target, i, val-diff+diff*curVal, path+"*"+ number, res, diff*curVal);
      }
    }
  }
}
