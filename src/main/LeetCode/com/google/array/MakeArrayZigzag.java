package com.google.array;

public class MakeArrayZigzag {
  public static int movesToMakeZigzag(int[] nums) {
    // first make even move
    int even = 0, N = nums.length;
    for (int i=1; i<N; i+=2) {
      int t = 0;
      if (nums[i]>=nums[i-1]) t = nums[i]-nums[i-1] + 1;
      if (i+1 < N && nums[i]>=nums[i+1])
        t = Math.max(t, nums[i]-nums[i+1]+1);
      even += t;
    }
    int odd = 0;
    for (int i=0; i<N; i+=2) {
      int t = 0;
      if (i>0 && nums[i]>=nums[i-1]) t = nums[i]-nums[i-1]+1;
      if (i+1<N && nums[i]>=nums[i+1])
        t = Math.max(t, nums[i]-nums[i+1]+1);
      odd += t;
    }
    return Math.min(even, odd);
  }

  public static void main(String... args) {
    int moves = movesToMakeZigzag(new int[]{9, 6, 1, 6, 2});
    System.out.println(moves);
  }
}
