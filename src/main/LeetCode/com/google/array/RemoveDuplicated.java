package com.google.array;

/**
 * Created by ychang on 3/15/2017.
 */
public class RemoveDuplicated {
  public int removeDuplicates(int[] nums) {
    if (nums.length<=1) return nums.length;
    int res=0;
    for (int i=1; i<nums.length; i++) {
      if (nums[i]!=nums[res]) nums[++res]=nums[i];
    }
    return res+1;
  }
}
