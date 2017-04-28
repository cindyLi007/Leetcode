package com.google.two.pointers;

import java.util.Arrays;

/**
 * Created by ychang on 2/16/2017.
 * Two pointers, i, and currentNonZero
 */
public class MoveZeroes {
  public void moveZeroes(int[] nums) {
    if (nums==null || nums.length<2) return;

    int currentNonZero=0;
    // shift all non zero element, overwrite zero element
    for (int i=0; i<nums.length; i++) {
      if (nums[i]!=0) nums[currentNonZero++]=nums[i];
    }
    Arrays.fill(nums, currentNonZero, nums.length, 0);
  }

}
