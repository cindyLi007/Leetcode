package interview.amazon.onsite;

/**
 * Created by ychang on 4/4/2017.
 */
public class FindItemNumber {
  public int findItemTimes(int[] nums, int target) {
    int[] range = findHelper(nums, target, 0, nums.length-1);
    return range[1]-range[0]+1;
  }

  private int[] findHelper(int[] nums, int target, int low, int high) {
    if (low>high) return new int[]{-1, -2};
    int mid = low + (high-low)/2;
    if (target<nums[mid]) {
      return findHelper(nums, target, low, mid-1);
    } else if (target>nums[mid]) {
      return findHelper(nums, target, mid + 1, high);
    }
    int[] left = findHelper(nums, target, low, mid-1);
    int[] right = findHelper(nums, target, mid+1, high);
    int start = left[0]<0 ? mid : left[0], end = right[1]<0 ? mid : right[1];
    return new int[]{start, end};
  }
}
