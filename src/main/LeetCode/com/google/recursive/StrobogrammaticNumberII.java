package com.google.recursive;

import java.util.*;

/**
 * Created by ychang on 4/1/2017.
 */
public class StrobogrammaticNumberII {
  // Time: O(5^(N/2)), Space: (N/2)
  public List<String> findStrobogrammatic_recursive(int n) {
    // we need handle the most outer separately, because we will NOT put leading 0 and tailing 0 in that case
    return helper(n, true);
  }

  private List<String> helper(int n, boolean root) {
    List<String> res = new ArrayList();
    // base case n==0 or n==1
    if (n==0) return Arrays.asList(new String[]{""});
    if (n==1) return Arrays.asList(new String[]{"0", "1", "8"});
    // each time we jump 2 which means we need not get (n-1) list.
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

  public List<String> findStrobogrammatic(int n) {
    List<String> res = new ArrayList();
    if (n==0) return res;
    if (n%2==0) res.add("");
    else {
      res.add("0");
      res.add("1");
      res.add("8");
    }
    int i = (n%2)+1; // i is the start index from the pos after the middle
    // each time i jump 2
    for (; i<n; i+=2) {
      List<String> temp = new ArrayList();
      for (String s : res) {
        if (i!=n-1) temp.add("0" + s + "0");
        temp.add("1" + s + "1");
        temp.add("8" + s + "8");
        temp.add("6" + s + "9");
        temp.add("9" + s + "6");
      }
      res = temp;
    }
    return res;
  }

  public static void main(String... args) {
    StrobogrammaticNumberII strobogrammaticNumberII = new StrobogrammaticNumberII();
    List<String> strobogrammatic = strobogrammaticNumberII.findStrobogrammatic_recursive(2);
    strobogrammatic.forEach(o-> System.out.print(o + ", "));
  }
}
