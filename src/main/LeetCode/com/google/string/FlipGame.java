package com.google.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 3/29/2017.
 */
public class FlipGame {
  public List<String> generatePossibleNextMoves(String s) {
    List<String> res = new LinkedList();
    char[] ch = s.toCharArray();
    for (int i=1; i<ch.length; i++) {
      if (ch[i]=='+' && ch[i-1]=='+') {
        res.add(s.substring(0, i-1)+"--"+s.substring(i+1));
      }
    }
    return res;
  }

  public List<String> generatePossibleNextMoves_abstract(String s) {
    List list = new ArrayList();
    /**
     * s.indexOf(str, fromIndex) return the first occurrence of the specified substring, so i will move to next index,
     * or return -1 if no such occurrence.
     */
    for (int i=-1; (i = s.indexOf("++", i+1)) >= 0; )
      list.add(s.substring(0, i) + "--" + s.substring(i+2));
    return list;
  }
}
