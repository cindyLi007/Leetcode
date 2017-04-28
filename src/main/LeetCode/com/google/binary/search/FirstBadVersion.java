package com.google.binary.search;

/**
 * Created by ychang on 4/27/2017.
 */
public class FirstBadVersion {

  public int firstBadVersion(int n) {
    int low=1, high=n;
    while (low<high) {
      int mid = low + (high-low)/2;
      if (isBadVersion(mid)) {
        high=mid;
      } else {
        low=mid+1;
      }
    }
    return low;
  }

  private boolean isBadVersion(int mid) {
    return false;
  }
}
