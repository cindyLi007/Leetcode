package com.google.Tree;

/**
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent
 * nodes to child nodes).
 */
// Time: O(n^2), Space: O(h)
/**
 * pathSumFrom takes O(n)
 * pathSum has recurrence relation T(n) = n + 2T(n/2) = nlogn for balance tree.
 * pathSum has recurrence relation T(n) = n + T(n-1) = n^2 for linear tree.
 */
public class PathSumIII {
  public int pathSum(TreeNode root, int sum) {
    if (root == null) return 0;
    return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
  }

  private int pathSumFrom(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }
    int count = root.val == sum ? 1 : 0;
    return count + pathSumFrom(root.left, sum - root.val) + pathSumFrom(root.right, sum - root.val);
  }
}
