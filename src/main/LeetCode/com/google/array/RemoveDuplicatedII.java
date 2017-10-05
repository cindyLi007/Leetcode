package com.google.array;

/**
 * Created by ychang on 10/4/2017.
 */
public class RemoveDuplicatedII {
  public int removeDuplicates(int[] nums) {
    int i=0; // pointer next elem should copy to
    for (int n : nums) {
      /** if n==nums[i-2], that mean from [i-2, i-1], n has show twice, so we should stick i in current position till
       * find next diff num
       */
      if (i<2 || n>nums[i-2]) {
        nums[i++]=n;
      }
    }
    return i;
  }

}
