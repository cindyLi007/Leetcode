package com.google.minimax;

import java.util.HashMap;
import java.util.Map;

public class FlipGameII {
  // Time: O(2^N), Space: O(2^N)
  Map<String, Boolean> map = new HashMap();
  public boolean canWin(String s) {
    if (map.containsKey(s)) return map.get(s);
    // it is not easy to ensure a play can win, but it is easy to check whether a play lose (if there is no string he can flip)
    if (s==null || s.length()<2 || s.indexOf("++")==-1) {
      map.put(s, false);
      return false;
    }
    for (int x=0; x<s.length()-1; x++) {
      if (s.substring(x, x+2).equals("++")) {
        String s1 = s.substring(0, x) + "--" + s.substring(x+2);
        // 确定我们能赢实际上是通过确定对手无路可走来确定的
        if (!canWin(s1)) {
          map.put(s, true);
          return true;
        }
      }
    }
    map.put(s, false);
    return false;
  }
}
