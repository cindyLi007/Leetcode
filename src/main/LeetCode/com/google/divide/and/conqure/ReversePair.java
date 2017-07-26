package com.google.divide.and.conqure;

/**
 * Created by ychang on 6/12/2017.
 */
public class ReversePair {
  public int reversePairs(int[] nums) {
    return reversePairs(nums, 0, nums.length-1);
  }

  private int reversePairs(int[] nums, int l, int h) {
    if (l>=h)
      return 0;
    int m = l + (h - l)/2;
    /**
     * after we finish reversePairs, we guarantee that nums from l to h is sorted
     */
    int res = reversePairs(nums, l, m) + reversePairs(nums, m + 1, h);
    int i = l, j = m + 1, k = 0, p = m + 1;
    int[] merge = new int[h - l + 1];

    while (i<=m) {
      while (p<=h && nums[i]>2L*nums[p])
        p++;
      res += p - (m + 1);

      while (j<=h && nums[i]>=nums[j])
        merge[k++] = nums[j++];
      merge[k++] = nums[i++];
    }

    while (j<=h)
      merge[k++] = nums[j++];

    System.arraycopy(merge, 0, nums, l, merge.length);
    return res;
  }
}
