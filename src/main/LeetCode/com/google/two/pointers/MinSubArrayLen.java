package com.google.two.pointers;

/**
 * Created by ychang on 5/10/2017.
 */
public class MinSubArrayLen {
  public int minSubArrayLen(int s, int[] nums) {
    int len=nums.length+1, start=0, sum=0;
    for (int i=0; i<nums.length; i++) {
      sum+=nums[i];
      while (sum>=s) {
        int temp = i-start+1;
        if (temp==1) return temp;
        if (temp<len) len=temp;
        sum-=nums[start++];
      }
    }
    return len==nums.length+1 ? 0 : len;
  }
}
