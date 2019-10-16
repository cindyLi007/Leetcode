package com.google.divide.and.conqure;

public class ReversePairs {
  public int reversePairs(int[] nums) {
    return helper(nums, 0, nums.length - 1);
  }

  private int helper(int[] nums, int left, int right) {
    if (left >= right) return 0; // only one item or no item
    int m = left + (right - left) / 2;
    int res = helper(nums, left, m) + helper(nums, m + 1, right);
    // 我们把nums分成两个部分 左边和右边 现在我们已经算完了左边和右边分别的count of reverse pairs
    // now we merge left and right side, we only need check if i from left, j from right, count of reverse pair
    int k = m + 1;
    for (int i = left; i <= m; i++) {
      while (k <= right && nums[i] > 2L * nums[k]) k++;
      res += k - (m + 1);
      // no need to reset k to m+1, that is because we only care the count, since left side and right side are sorted, when we move to
      // next item, nums[i+1] >= nums[i] we can guarantee that all nums[j] (m+1<=j<=k) must satisfy the condition, we only
      // need move forward to check whether bigger nums[k] still have nums[i] > nums[k] * 2;
    }

    int[] copy = new int[right - left + 1];
    k = m + 1;
    int i = left, j = 0;
    while (k <= right && i <= m) {
      copy[j++] = nums[i] < nums[k] ? nums[i++] : nums[k++];
    }
    while (k <= right) copy[j++] = nums[k++];
    while (i <= m) copy[j++] = nums[i++];
    System.arraycopy(copy, 0, nums, left, copy.length);
    return res;
  }

  public static void main(String... args) {
    ReversePairs reversePairs = new ReversePairs();
    System.out.println(reversePairs.reversePairs(new int[]{1, 3, 2, 3, 1})); // should be 2
    System.out.println(reversePairs.reversePairs(new int[]{2, 4, 3, 5, 1})); // should be 3
    System.out.println(reversePairs.reversePairs(new int[]{-5, -5})); // should be 1
  }
}
