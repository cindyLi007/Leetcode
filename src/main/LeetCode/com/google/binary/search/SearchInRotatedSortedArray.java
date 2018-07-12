package com.google.binary.search;

/**
 * Created by ychang on 1/25/2017.
 */
public class SearchInRotatedSortedArray {

  // Time: O(logN), Space: O(1)
  public int search(int[] nums, int target) {
    int low = 0, high = nums.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target)
        return mid;

      /**
       * we need first determine the rotated part is in left or right
       */
      if (nums[mid] > nums[high]) { // rotate happen in [mid+1, high], the sorted part is [low, mid+1]
        if (target >= nums[low] && target < nums[mid]) { // the target is in the sorted part
          high = mid - 1;
        } else
          low = mid + 1;
      } else { // rotate happen in [low, mid], sorted part is [mid, high]
        if (target > nums[mid] && target <= nums[high])
          low = mid + 1;
        else
          high = mid - 1;
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
