package com.google.bit.manipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ychang on 3/30/2017.
 * All abbreviation can be represent by bit. for example, for "word" 0101 is w1r1, 0111 is w3. We need loop [0, 2^len-1]
 * bit integer, for each integer, loop from 0 to len-1
 */
public class GenerateAbbreviation {
  public List<String> generateAbbreviations(String word) {
    List<String> res = new ArrayList();
    char[] ch = word.toCharArray();
    int len=ch.length;
    for (int mask=0; mask<Math.pow(2, len); mask++) {
      int count=0;
      StringBuilder sb = new StringBuilder();
      for (int pos=0; pos<len; pos++) {
        if ((1<<pos & mask)>0) count++;
        else {
          if (count>0) {
            sb.append(count);
            count=0;
          }
          sb.append(ch[pos]);
        }
      }
      res.add(sb.append(count>0 ? count : "").toString());
    }
    return res;
  }
}
