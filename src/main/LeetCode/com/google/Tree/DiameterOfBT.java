package com.google.Tree;

/**
 * Created by ychang on 9/19/2017.
 */
public class DiameterOfBT {
  public int diameterOfBinaryTree(TreeNode root) {
    return diameter(root)[1];
  }

  private int[] diameter(TreeNode root) {
    if (root==null)
      return new int[]{0, 0};
    int[] left = diameter(root.left);
    int[] right = diameter(root.right);
    /**
     * rootPath is from this node to its root's diameter
     */
    int rootPath = Math.max(left[0], right[0]) + 1;
    int max = Math.max(Math.max(left[1], right[1]), left[0] + right[0]);
    return new int[]{rootPath, max};
  }
}
