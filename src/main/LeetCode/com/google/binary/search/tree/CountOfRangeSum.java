package com.google.binary.search.tree;

/**
 * Created by ychang on 6/14/2017.
 */
public class CountOfRangeSum {
  public int countRangeSum(int[] nums, int lower, int upper) {
    int n = nums.length;
    if (n==1) return inRange(nums[0], lower, upper) ? 1 : 0;
    int[] s = new int[n];
    for (int i = 0; i<n; i++) {
      s[i] = i==0 ? nums[i] : s[i - 1] + nums[i];
    }
    // we need find [i, j] which satisfying lower<=s[j]-s[i-1]<=upper where j>=i, i==0 s[i-1]=0
    int res = 0;
    int[] tree = new int[2*n];
    for (int i = n, j = 0; i<2*n; i++, j++) {
      tree[i] = s[j];
    }
    for (int i = n - 1; i>0; i--) {
      if (inRange(tree[i*2], lower, upper))
        res++;
      if (inRange(tree[i*2 + 1], lower, upper))
        res++;
      tree[i] = tree[i*2 + 1] - tree[i*2];
    }
    return res;
  }

  private boolean inRange(int n, int l, int u) {
    return n<=u && n>=l;
  }
}
