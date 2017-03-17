package com.google.dp;

/**
 * Created by ychang on 3/9/2017.
 */
public class MaxProductSubarray {
  public int maxProduct(int[] nums) {
    if (nums==null || nums.length==0)
      return 0;
    if (nums.length==1)
      return nums[0];

    /** res hold till i what is the maxProduct, may not continue to i
      * min/max hold till i what is the min/max, must be continue to i, so we can use it calculate next one
    */
    int res = nums[0], min = nums[0], max = nums[0];
    for (int i = 1; i<nums.length; i++) {
      /** notice we must have temp value to save max and min, if we use
       * max=Math.max(Math.max(nums[i]*min, nums[i]*max), nums[i])
       * min=Math.min(Math.min(nums[i]*min, nums[i]*max), nums[i])
       * when we calculate min, we have erase the prev max
       */
      int tempMax = Math.max(nums[i]*min, nums[i]*max);
      int tempMin = Math.min(nums[i]*min, nums[i]*max);
      max = Math.max(tempMax, nums[i]);
      min = Math.min(tempMin, nums[i]);
      res = Math.max(res, max);
    }
    return res;
  }
}
