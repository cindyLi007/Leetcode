package com.google.two.pointers;

import java.util.Arrays;

/**
 * Created by ychang on 2/16/2017.
 * Two pointers, i, and currentNonZero
 */
public class MoveZeroes {
  public void moveZeroes_shift(int[] nums) {
    if (nums==null || nums.length<2) return;

    int currentNonZero=0;
    // shift all non zero element, overwrite zero element
    for (int i=0; i<nums.length; i++) {
      if (nums[i]!=0) nums[currentNonZero++]=nums[i];
    }

    /*while (index<nums.length) {
      nums[index++]=0;
    }*/
    Arrays.fill(nums, currentNonZero, nums.length, 0);
  }

  /**
   * beat 16%, the idea if when find a zero element, try to find first next non-zero and switch them, or all remaining
   * elements are zero.
   */
  public void moveZeroes(int[] nums) {
    if (nums==null || nums.length<2) return;

    int i=0, firstZero=-1;
    while (i<nums.length) {
      if (nums[i]==0) {
        if (firstZero<0) firstZero=i;
        while (i<nums.length && nums[i]==0) i++;
        if (i<nums.length)
        /**
         * here only increment firstZero, keep i as the last zero, so we can check all remaining non-zero elements
         */
          swap(i, firstZero++, nums);
      } else i++;
    }
  }

  private void swap(int i, int j, int[] nums){
    int temp = nums[i];
    nums[i]=nums[j];
    nums[j]=temp;
  }

}
