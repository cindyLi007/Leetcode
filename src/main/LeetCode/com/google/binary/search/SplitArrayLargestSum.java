package com.google.binary.search;

/**
 * Created by ychang on 5/31/2017.
 * "Trial and Error"
 * https://leetcode.com/problems/minimize-max-distance-to-gas-station/discuss/113629/Approach-the-problem-using-the-%22trial-and-error%22-algorithm
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty
 * continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
 * We can covert this problem to find a cap which makes in all m subarrays, the largest sum <= cap, use binary search to do it
 * 1. we need find the cap, it should >= the max number in the array and <= sum of all numbers in the array
 * 2. so use the mid value of the above 2 values, check with this value whether we can construct a series of subarrays
 *    satisfying the condition.
 * 3. how to validate a number, we determine the minimum number of subarrays we can do with this cap. If it's smaller than
 *    or equal to m, this cap is OK. Wait, aren't we supposed to create exactly m subarrays? Yeah, but if we can do it
 *    with fewer, we can just split some up so we have exactly m
 *    So how to find the minimum number of subarrays we can do with a certain cap? Always stuff as many numbers into an
 *    subarray as we can, only start a new subarray when the current number doesn't fit into the previous subarray. (exceeds
 *    the cap value)
 * 4. if the cap can satisfy the condition, we move it to smaller (high=mid-1), otherwise move it to greater (low=mid+1)
 * time complexity is O(N*lgSum)
 */
public class SplitArrayLargestSum {

  public int splitArray(int[] nums, int m) {
    int sum=0, max=Integer.MIN_VALUE;
    for (int num : nums) {
      if (num>max) max=num;
      sum+=num;
    }
    if (m==nums.length) return max;
    if (m==1) return sum;
    int l=max, r=sum;
    // O(lgSum)
    while (l<=r) {
      int mid = (l+r)/2; // this is a cap
      if (canSplit(mid, nums, m)) {
        r=mid-1;
      } else l=mid+1;
    }
    return l;
  }

  // O(N)
  private boolean canSplit(int cap, int[] nums, int m) {
    int count=1, total=0;
    for (int num : nums) {
      total+=num;
      if (total>cap) {
        total=num;
        count++;
        if (count>m) return false;
      }
    }
    return true;
  }
}
