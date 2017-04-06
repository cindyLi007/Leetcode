package com.google.two.pointers;

/**
 * Created by ychang on 3/28/2017.
 * 1.a>0, two ends in original array are bigger than center if you learned middle school math before.
 * 2.a<0, center is bigger than two ends.
 */
public class SortTransformedArray {
  public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
    int len = nums.length;
    int[] res = new int[len];
    /** if a>0, that mean left and right should be max, so from end to start to fill the res array; otherwise,
     * from start to end to fill the res array
     */
    int index = a>0 ? len-1:0;
    int left=0, right=len-1;
    while (left<=right) {
      int res_left = a*nums[left]*nums[left]+b*nums[left]+c;
      int res_right = a*nums[right]*nums[right]+b*nums[right]+c;
      if (a>0) {
        if (res_left>res_right) {
          res[index--] = res_left;
          left++;
        } else {
          res[index--] = res_right;
          right--;
        }
      } else {
        if (res_left<res_right) {
          res[index++] = res_left;
          left++;
        } else {
          res[index++] = res_right;
          right--;
        }
      }
    }
     return res;
  }
}
