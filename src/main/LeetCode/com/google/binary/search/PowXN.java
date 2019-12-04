package com.google.binary.search;

/**
 * Created by ychang on 1/31/2017. EPI 4.7
 * We should NOT use "for" loop since n can be huge, so each time, set x to x*x.
 * Also need consider edge cases, such as n==0, x==0, n<0, when n is MIN_VALUE, since -n overflow, we need first n++
 */
public class PowXN {

  public double myPow_nonRecursive(double x, int n) {
    double res = 1;
    if (n<0)
      x = 1/x;
    if (n==Integer.MIN_VALUE) { // if n==MIN_VALUE, when we abs it, will overflow, so first +1
      n++;
      res *= x;
    }
    n = Math.abs(n);
    while (n!=0) {
      if ((n&1) != 0) res *= x;
      x *= x;
      n >>= 1;
    }
    return res;
  }
}
