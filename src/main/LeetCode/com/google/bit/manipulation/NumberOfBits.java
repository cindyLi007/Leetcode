package com.google.bit.manipulation;

/**
 * Created by ychang on 8/8/2017.
 */
public class NumberOfBits {
  public int hammingWeight(int n) {
    int ones = 0;
    while(n!=0) {
      ones = ones + (n & 1);
      /** >> is arithmetic shift right, >>> is logical shift right. in this problem, we treat n as an unsinged value
       * In an arithmetic shift, the sign bit is extended to preserve the signedness of the number.
       */
      n = n>>>1;
    }
    return ones;
  }
}
