package com.google.bit.manipulation;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 3/28/2017. This can beat 31%
 */
public class BinaryWatch {
  public List<String> readBinaryWatch(int num) {
    List<String> res = new LinkedList();
    for (int hour=0; hour<12; hour++) {
      for (int min=0; min<60; min++) {
        /**
         * the reason hour shift right 6 bits is to avoid they do sum to mess up bits
         */
        if (Integer.bitCount(hour*64+min)==num) {
          res.add(String.format("%d:%02d", hour, min));
        }
      }
    }
    return res;
  }
}
