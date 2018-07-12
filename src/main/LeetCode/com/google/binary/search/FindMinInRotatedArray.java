package com.google.binary.search;

/**
 * Created by ychang on 1/24/2017.
 * Rotate array 0 1 2 4 5 6 7, it might become 4 5 6 7 0 1 2
 * If the first member < the last member, there's no rotation in the array. So we could directly return the first element.
 * Time: O(logN), Space: O(1)
 */
public class FindMinInRotatedArray {
  public int findMin(int[] nums) {
    int lo=0, hi=nums.length-1;
    /**
     * must be lo<hi instead of lo<=hi, because if there is only one element, lo==hi, will go into unlimited loop
     */
    while (lo<hi) {
      if (nums[lo]<nums[hi]) {
        return nums[lo];
      }
      int mid = (hi+lo)/2;
      /**
       * use mid compares to hi, can ignore equals, because when lo<hi, mid maybe equal to lo, but could not equal to hi
       * */
      if (nums[mid]>nums[hi]) { // rotation happens in second part
        lo=mid+1;
      } else {
        /**
         * must hi=mid instead of hi=mid+1, because mid may be the rotation start point
         */
        hi=mid;
      }
    }
    return nums[lo];
  }
}
