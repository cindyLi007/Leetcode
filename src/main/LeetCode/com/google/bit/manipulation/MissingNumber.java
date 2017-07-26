package com.google.bit.manipulation;

/**
 * Created by ychang on 7/24/2017.
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * For example, Given nums = [0, 1, 3] return 2.
 */
public class MissingNumber {
  public int missingNumber(int[] nums) {
    /** because index [0, n-1] take [0, n], there must be an index (or n) has no matched number, for all matched
     * index-number pair, using xor can get 0, 0^a=a, finally we can find the missing number
    */
    int n=nums.length, sum=n;
    for (int i=0; i<n; i++) {
      sum^=i^nums[i];
    }
    return sum;
    // we can just add [0, n] minus Sum(nums[0], nums[n-1])
    /* int n=nums.length, sum=n, temp=0;
     for (int i=0; i<n; i++) {
         temp+=nums[i];
         sum+=i;
     }
     return sum-temp;*/
  }
}
