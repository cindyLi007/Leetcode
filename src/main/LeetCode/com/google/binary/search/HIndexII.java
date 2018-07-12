package com.google.binary.search;

/**
 * Created by ychang on 6/4/2017.
 */
public class HIndexII {
  /**
   * this can beat 100% Time: O(lgN)
   */
  public int hIndex(int[] citations) {
    int len=citations.length;
    int low=0, high=len-1;
    while (low<=high) {
      int mid = low+(high-low)/2;
      if (len-mid<=citations[mid]) {
        // since array is sorted, we can guarantee that there are at least (len-mid) papers whose value >= citations[mid]
        high=mid-1;
      }
      else {
        low=mid+1;
      }
    }
    return len-low;
  }
}
