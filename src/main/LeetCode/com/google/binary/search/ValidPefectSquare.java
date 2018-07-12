package com.google.binary.search;

public class ValidPefectSquare {
  public boolean isPerfectSquare(int num) {
    // must use long to avoid overflow
    long low=1, high=num;
    while (low<=high) {
      long mid=low+(high-low)/2;
      if (mid*mid==num) { // could NOT use mid==num/mid, for example mid=2, num=5
        return true;
      }
      if (mid<num/mid) {
        low=mid+1;
      }
      else {
        high=mid-1;
      }
    }
    return false;
  }
}
