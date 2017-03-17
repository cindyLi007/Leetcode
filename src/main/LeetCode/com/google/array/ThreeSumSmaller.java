package com.google.array;

import java.util.Arrays;

/**
 * Created by ychang on 12/14/2016.
 */
public class ThreeSumSmaller {
  public int threeSumSmaller(int[] nums, int target) {
    int res = 0;
    /*
     Sort the array first. Then, for each element, we use the two pointer approach to find the number of triplets that meet the requirements.
     */
    Arrays.sort(nums);
    int len = nums.length;
    for (int i = 0; i<len - 2; i++) {
      int lo = i + 1, hi = len - 1;
      while (lo<hi) {
        /*
         If we know that (nums[i]+nums[lo]+nums[hi]) < target, since the array is sorted, we can replace hi with any
         element from lo+1 to hi, the number of elements meet the requirement is (hi-lo) (exclude lo).
         Therefore, we can just add (hi-lo) to the triplet count.
         */
        if (nums[i] + nums[lo] + nums[hi]<target) {
          res += hi - lo;
          lo++;
        } else {
          hi--;
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    ThreeSumSmaller tss = new ThreeSumSmaller();
    int[] array = new int[]{3, 1, 0, -2};
    int res = tss.threeSumSmaller(array, 4);
    System.out.println(res);
  }
}
