package com.google.binary.segment.tree;

/**
 * Created by ychang on 6/12/2017.
 * this can beat 73%
 */
public class RangeSumQueryMutable {
  TreeNode root;

  public RangeSumQueryMutable(int[] nums) {
    root = buildTree(nums, 0, nums.length - 1);
  }

  private TreeNode buildTree(int[] nums, int l, int h) {
    // first consider 2 base cases
    if (l>h)
      return null;
    if (l==h)
      return new TreeNode(nums[l], l, h);
    int m = l + (h - l)/2;
    TreeNode root = new TreeNode(0, l, h);
    root.left = buildTree(nums, l, m);
    root.right = buildTree(nums, m + 1, h);
    // since l<h, root.left and root.right must be non-null, need NOT consider NPE
    root.sum = root.left.sum + root.right.sum;
    return root;
  }

  public void update(int i, int val) {
    update(root, i, val);
  }

  private void update(TreeNode root, int idx, int val) {
    // first consider 2 base cases, guarantee idx in range
    if (root==null || idx>root.h || idx<root.l)
      return;
    if (root.l==root.h) // from prev judgement, we know idx>=l && idx<=h
      root.sum = val;
    else {
      int m = root.l + (root.h - root.l)/2;
      if (idx<=m)
        update(root.left, idx, val);
      else
        update(root.right, idx, val);
      // since idx in [root.l, root.h] && root.l!=root.h, root.left and root.right must be non-null, need NOT consider NPE
      root.sum = root.left.sum + root.right.sum;
    }
  }

  public int sumRange(int i, int j) {
    return sumRange(root, i, j);
  }

  private int sumRange(TreeNode root, int i, int j) {
    // first consider 2 base cases
    if (i<root.l || j>root.h)
      return 0;
    if (i==root.l && j==root.h) // no need a leaf node
      return root.sum;
    int m = root.l + (root.h - root.l)/2;
    if (i>m)
      return sumRange(root.right, i, j);
    if (j<=m)
      return sumRange(root.left, i, j);
    return sumRange(root, i, m) + sumRange(root, m + 1, j);
  }

  class TreeNode {
    int l, h, sum;
    TreeNode left, right;

    TreeNode(int v, int low, int high) {
      l = low;
      h = high;
      sum = v;
    }
  }
}
