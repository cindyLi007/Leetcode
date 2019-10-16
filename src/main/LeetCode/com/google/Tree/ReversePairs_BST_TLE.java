package com.google.Tree;

/**
 * Created by ychang on 6/7/2017.
 * This BST solution will TLE, because it is not self-balanced, for bad case [[0,1 ... 49999], it is too deep.
 */
public class ReversePairs_BST_TLE {
  public int reversePairs(int[] nums) {
    int res = 0;
    TreeNode root = null;
    for (int i = 0; i<nums.length; i++) {
      res += search(root, nums[i] * 2L + 1);
      root = insert(root, nums[i]);
    }
    return res;
  }

  // find number >=val
  private int search(TreeNode root, double val) {
    if (root==null)
      return 0;
    if (root.val == val) return root.count;
    if (root.val < val)
      return search(root.right, val);
    return search(root.left, val) + root.count;
  }

  private TreeNode insert(TreeNode root, int val) {
    if (root==null)
      return new TreeNode(val);
    if (val>root.val) {
      root.count++;
      root.right = insert(root.right, val);
    } else if (val<root.val) {
      root.left = insert(root.left, val);
    } else
      root.count++;
    return root;
  }

  class TreeNode {
    int val, count;
    TreeNode left, right;

    TreeNode(int v) {
      val = v;
      count = 1;
    }
  }
}
