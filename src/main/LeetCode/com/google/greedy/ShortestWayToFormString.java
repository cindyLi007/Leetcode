package com.google.greedy;

import java.util.BitSet;

public class ShortestWayToFormString {

  // Time: O(N*M), Space: O(1)
  public int shortestWay(String source, String target) {
    int N = source.length(), M = target.length(), res = 0;
    if (M==0) return res;

    BitSet bitSet = new BitSet(26);
    for (char c : source.toCharArray()) bitSet.set(c-'a');

    for (int i=0, j=0; j<M; i++) {
      if (i==N) {
        i=0;
        res++;
      }
      char c1 = source.charAt(i), c2 = target.charAt(j);
      if (!bitSet.get(c2-'a')) return -1;
      if (c1==c2) j++;
    }
    return res+1;
  }

  public int shortestWay_withOutBitSet(String source, String target) {
    int N = source.length(), M = target.length(), res = 0;
    if (M==0) return res;

    for (int j=0; j<M; ) {
      res++;
      int ori = j;
      // if loop through soure could advance target, that means there is no char in source for target.charAt(j)
      for (int i=0; j<M && i<N; i++) {
        if (source.charAt(i)==target.charAt(j)) j++;
      }
      if (j==ori) return -1;
    }
    return res;
  }
}
