package com.google.Tree;

/**
 * Created by ychang on 6/7/2017.
 * This BST solution will TLE, because it is not self-balanced, for bad case [[0,1 ... 49999], it is too deep.
 */
public class ReversePairs_BST_TLE {
  public int reversePairs(int[] nums) {
    int res = 0;
    TreeNode root = null;
    for (int i = nums.length - 1; i>=0; i--) {
      /**
       * here we must use nums[i]/2.0, could not use (nums[i]-1)/2, because 0, it till 0, but should be -1
       */
      res += search(root, nums[i]/2.0, 0);
      root = insert(root, nums[i]);
    }
    return res;
  }

  private int search(TreeNode root, double val, int prev) {
    if (root==null)
      return prev;
    if (root.val<val)
      return search(root.right, val, prev + root.small + root.count);
    else if (root.val>val)
      return search(root.left, val, prev);
    return root.small + prev;
  }

  private TreeNode insert(TreeNode root, int val) {
    if (root==null)
      return new TreeNode(val);
    if (val>root.val)
      root.right = insert(root.right, val);
    else if (val<root.val) {
      root.small++;
      root.left = insert(root.left, val);
    } else
      root.count++;
    return root;
  }

  class TreeNode {
    int val, count, small;
    TreeNode left, right;

    TreeNode(int v) {
      val = v;
      count = 1;
      small = 0;
    }
  }
}
