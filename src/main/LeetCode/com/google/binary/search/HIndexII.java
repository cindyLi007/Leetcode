package com.google.binary.search;

/**
 * Created by ychang on 6/4/2017.
 */
public class HIndexII {
  /**
   * this can beat 77%
   */
  public int hIndex(int[] citations) {
    int l = 0, N = citations.length, h = N - 1;
    while (l<=h) {
      int mid = l + (h - l)/2;
      if (citations[mid]==(N - mid)) // [0, 1, 3, 5, 6] mid=2, N=5 citations[2]=3 == (5-2)
        return N - mid;
      if (citations[mid]>(N - mid)) // [56, 57, 68] citations[1]>(3-1)
        h = mid - 1;
      else
        l = mid + 1; // [0, 0, 0] citation[1]=0<(3-1)
    }
    return N - l; //[100] h=-1, l=0, N-l=1
  }
}
