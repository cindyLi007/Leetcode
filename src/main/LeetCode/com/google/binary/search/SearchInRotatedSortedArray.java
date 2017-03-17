package com.google.binary.search;

/**
 * Created by ychang on 1/25/2017.
 */
public class SearchInRotatedSortedArray {
  public int search(int[] nums, int target) {
    int lo = 0, hi = nums.length - 1;
    while (lo<=hi) {
      int mid = (lo + hi)/2;
      if (nums[mid]==target)
        return mid;
      if (nums[mid]<nums[hi]) { // second part is ordered
        if (target<nums[mid] || target>nums[hi])
          hi = mid - 1;
        else
          lo = mid + 1;
      } else { // first part is ordered
        if (target<nums[lo] || target>nums[mid])
          lo = mid + 1;
        else
          hi = mid - 1;
      }
    }
    return -1;
  }

  public int search_rotatedIndex(int[] nums, int target) {
    int lo = 0, hi = nums.length - 1;

    // find rotated index, the smallest element rotated index
    while (lo<hi) {
      int mid = (lo + hi)/2;
      if (nums[mid]>nums[hi]) { // rotation in second part
        lo = mid + 1;
      } else { // rotation in first part
        hi = mid;
      }
    }

    int pivot = lo;
    lo = 0;
    hi = nums.length - 1;
    while (lo<=hi) {
      int mid = (lo + hi)/2;
      int adjustMid = (mid + pivot)%nums.length;
      if (nums[adjustMid]==target)
        return adjustMid;
      if (nums[adjustMid]<target)
        lo = mid + 1;
      else
        hi = mid - 1;
    }
    return -1;
  }
}
