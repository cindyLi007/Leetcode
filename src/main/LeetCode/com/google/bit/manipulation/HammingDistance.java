package com.google.bit.manipulation;

/**
 * Created by ychang on 5/31/2017.
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 */
public class HammingDistance {
  public int hammingDistance(int x, int y) {
    int diff = x^y;
    int res=0;
    while (diff!=0) {
      if ((diff&1)==1) res++;
      diff>>=1;
    }
    return res;
  }
}
