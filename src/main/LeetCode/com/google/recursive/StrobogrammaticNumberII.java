package com.google.recursive;

import java.util.*;

/**
 * Created by ychang on 4/1/2017.
 */
public class StrobogrammaticNumberII {
  public List<String> findStrobogrammatic(int n) {
    // we need handle the most outer separately, because we will NOT put leading 0 and tailing 0 in that case
    return helper(n, true);
  }

  private List<String> helper(int n, boolean root) {
    List<String> res = new ArrayList();
    if (n==0) return Arrays.asList(new String[]{""});
    if (n==1) return Arrays.asList(new String[]{"0", "1", "8"});
    List<String> list = helper(n-2, false);
    for (String str : list) {
      res.add("1" + str + "1");
      res.add("8" + str + "8");
      res.add("6" + str + "9");
      res.add("9" + str + "6");
      if (!root) res.add("0" + str + "0");
    }
    return res;
  }

  public static void main(String... args) {
    StrobogrammaticNumberII strobogrammaticNumberII = new StrobogrammaticNumberII();
    List<String> strobogrammatic = strobogrammaticNumberII.findStrobogrammatic(2);
    strobogrammatic.forEach(o-> System.out.print(o + ", "));
  }
}
