package com.google.math;

/**
 * Created by ychang on 6/5/2017.
 */
public class MySqrt {
  public int mySqrt(int x) {
    long h=x;
    while (h*h>x) {
      // x/h is the low, since h*h>x, x/h<sqrt(x)
      h=(h+x/h)/2;
    }
    return (int)h;
  }

  public int mySqrt_binarySearch(int x) {
    if (x==0) return 0;
    int h=x, l=x/h;
    while (h>l) {
      // x/h is the low, since h*h>x, x/h<sqrt(x)
      h=l+(h-l)/2;
      l=x/h;
    }
    return h;
  }
}
