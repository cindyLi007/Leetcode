package com.google.backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ychang on 4/2/2017.
 */
public class FlipGameII {
  public boolean canWin(String s) {
    Map<String, Boolean> map = new HashMap();
    return helper(s, map);
  }

  private boolean helper(String s, Map<String, Boolean> map) {
    if (map.containsKey(s)) return map.get(s);
    if (s.length() < 2 || s.indexOf("++") <0) {
      map.put(s, false);
      return false;
    }
    for (int i=0; i<s.length()-1; i++) {
      if (s.substring(i, i+2).equals("++") && !helper(s.substring(0, i) + "--" + s.substring(i+2), map)) {
        map.put(s, true);
        return true;
      }
    }
    map.put(s, false);
    return false;
  }
}
