package com.google.binary.search;

/**
 * This is a follow up problem to {@link SearchInRotatedSortedArray}, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 * Yes, with many duplicated, Time: O(N), Space: O(logN)
 */
public class SearchInRotatedSortedArrayII {

  public boolean search(int[] nums, int target) {
    return search(nums, target, 0, nums.length - 1);
  }

  private boolean search(int[] nums, int target, int low, int high) {
    if (low > high) return false;
    if (low == high) return nums[low] == target;

    int mid = low + (high - low) / 2;
    if (nums[mid] == target) return true;

    if (nums[mid] < nums[high]) { // the sorted part is [mid, high]
      if (target > nums[mid] && target <= nums[high])
        return search(nums, target, mid + 1, high);
      else
        return search(nums, target, low, mid - 1);
    } else if (nums[mid] > nums[high]) {
      if (target >= nums[low] && target < nums[mid])
        return search(nums, target, low, mid - 1);
      else
        return search(nums, target, mid + 1, high);
    } else { // nums[mid]==nums[high]
      if (nums[mid] != nums[low]) { // target must be in [left, mid-1]
        return search(nums, target, low, mid - 1);
      } else { // could not know where is the rotated point, for example [2, 2, 2, 3, 4, 2], must search both sides
        return search(nums, target, low, mid - 1) || search(nums, target, mid + 1, high);
      }
    }
  }
}
