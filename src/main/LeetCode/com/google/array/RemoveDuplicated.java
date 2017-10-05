package com.google.array;

/**
 * Created by ychang on 3/15/2017.
 */
public class RemoveDuplicated {
  public int removeDuplicates(int[] nums) {
    int i = 0; // i is the position of last no-dup item
    for (int j = 1; j<nums.length; j++) { // j is the running pointer
      if (nums[j]!=nums[i]) { // when current item is NOT duplicated with prev one
        nums[++i] = nums[j];
      }
    }
    return i + 1;
  }

  public int removeDuplicates_II(int[] nums) {
    int i=0;
    for (int j=2; j<nums.length; j++) {
      if (nums[j]!=nums[i]) {
        i+=2;
        nums[i]=nums[j];
      }
    }
    return i+1;
  }
}
