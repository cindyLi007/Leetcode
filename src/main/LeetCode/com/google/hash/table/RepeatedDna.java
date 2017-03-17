package com.google.hash.table;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by ychang on 2/9/2017.
 */
public class RepeatedDna {
  public List<String> findRepeatedDnaSequences(String s) {
    List<String> res = new LinkedList();
    Set<String> set = new HashSet();
    for (int i=0; i<=s.length()-10; i++) {
      String sub = s.substring(i, i+10);
      /**
       * put res.contains(sub) before set.add(sub) can improve performance
       */
      if (!res.contains(sub) && !set.add(sub)) {
        res.add(sub);
      }
    }
    return res;
  }
}
