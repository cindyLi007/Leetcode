package com.google.array;

/**
 * Created by ychang on 3/14/2017.
 */
public class ProductOfArrayExceptSelf {
  /**
   * this can beat 44%
   */
  public int[] productExceptSelf(int[] nums) {
    int len = nums.length;
    // left[i] is product till i from left, right[i] is product till i from right
    int[] res = new int[len], left = new int[len], right = new int[len];
    left[0]=1;
    for (int i=1; i<len; i++) {
      left[i]=left[i-1]*nums[i-1];
    }
    right[len-1]=1;
    for (int i=len-2; i>=0; i--) {
      right[i]=right[i+1]*nums[i+1];
    }
    for (int i=0; i<len; i++) {
      res[i]=left[i]*right[i];
    }
    return res;
  }

  /**
   * this beat 44%, but only use 1 extra space
   */
  public int[] productExceptSelf_improved(int[] nums) {
    int len = nums.length;
    int[] res=new int[len];
    res[0]=1;
    for (int i=1; i<len; i++) {
      res[i]=res[i-1]*nums[i-1];
    }
    int product=1;
    for (int i=len-2; i>=0; i--) {
      product*=nums[i+1];
      res[i]*=product;
    }
    return res;
  }
}
