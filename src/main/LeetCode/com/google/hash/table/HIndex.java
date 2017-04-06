package com.google.hash.table;

import java.util.Arrays;

/**
 * Created by ychang on 3/28/2017.
 * A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have
 * no more than h citations each. So if we sort the array, we need to find an index which (len-i)<=citations[i].
 */
public class HIndex {
  /**
   * this can beat 17%
   */
  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    int len = citations.length;
    for (int i = 0; i<len; i++) {
      if (len - i<=citations[i])
        return len - i;
    }
    return 0;
  }

  /**
   * this can beat 55%
   */
  public int hIndex_woSort(int[] citations) {
    int len=citations.length;
    /**
     * nums is an array to record how many paper cited this number i
     */
    int[] nums = new int[len+1];
    for (int i=0; i<len; i++) {
      if (citations[i]>=len) nums[len]++;
      else nums[citations[i]]++;
    }
    /**
     * temp is accumulated all papers which was cited at least i;
     */
    int temp=0;
    for (int i=len; i>=0; i--) {
      temp+=nums[i];
      if (temp>=i) return i;
    }
    return 0;
  }
}
