package com.google.binary.search;

/**
 * Created by ychang on 1/31/2017.
 * We should NOT use for since n can be huge, so each time, set x to x*x.
 * Also need consider edge cases, such as n==0, x==0, n<0, when n is MIN_VALUE, since -n overflow, we need first n++
 */
public class PowXN {
  public double myPow(double x, int n) {
    if(n == 0) {
      return 1;
    }
    if(x == 0) {
      return 0;
    }
    if( n < 0) {
      if( n == Integer.MIN_VALUE) {
        /**
          Make -2147483648 to -2147483647
        */
        n++;
        if(x < 0) {
          x = -x; //we made n odd so need to update sign
        }
      }
      n = -n;
      x = 1/x;
    }
    if(n % 2 == 0) {
      return myPow(x*x, n/2);
    }
    else {
      return x * myPow(x*x, n/2);
    }
  }
}
