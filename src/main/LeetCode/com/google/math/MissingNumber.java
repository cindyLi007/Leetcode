package com.google.math;

/**
 * Created by ychang on 3/19/2017.
 */
public class MissingNumber {
  public int missingNumber(int[] nums) {
    /**
     * if all prev index - value pair match, n is the missing number
    */
    int res = nums.length;
    for (int i=0; i<nums.length; i++) {
      /**
       * from i, if nums[i]>i (should be nums[i]=i+1), all the following number mismatch by 1 (i-nums[i]=-1),
       * i is the missing number (len-(len-1-(i-1)) = len-len+1+(i-1)=i
      */
      res+=i-nums[i];
    }
    return res;
  }
}
