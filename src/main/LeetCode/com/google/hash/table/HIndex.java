package com.google.hash.table;

import java.util.Arrays;

/**
 * Created by ychang on 3/28/2017.
 * A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have
 * no more than h citations each. this is find some relationship between index and value
 */
public class HIndex {
  /** If we sort the array, we need to find an index which (len-i)<=citations[i].
   * this can beat 17%
   */
  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    int N = citations.length;
    /**
     * citations[i]<N-i means we have NOT find a point, where VALUE of point >= N-i(remaining papers), since array is sorted
     */
    for (int i=0; i<N; i++) {
      if (citations[i]>=N-i) return N-i;
    }
    return 0;
  }

  /**
   * bucket sort. this can beat 55%
   */
  public int hIndex_woSort(int[] citations) {
    int n=citations.length;
    /**
     * papers is an array to record how many papers whose value is == i, that last one is to record how many papers value is >=n
     */
    int[] paper=new int[n+1];
    for (int num : citations) {
      if (num>n) paper[n]++;
      else paper[num]++;
    }
    /**
     * temp is accumulated all papers which was cited at least i;
     */
    int temp = 0;
    /**
     * The reason to scan from the end of the array is that we are looking for the greatest h-index.
     */
    for (int i = n; i>=0; i--) {
      temp += paper[i];
      if (temp>=i)
        return i; //must return i, could not return temp, because for [0, 0, 0, 0, 0], when i=0, temp is 5, but we result should be 0
    }
    return 0;
  }
}