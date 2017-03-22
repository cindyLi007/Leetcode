package com.google.bfs.dfs.dfs;

/**
 * Created by ychang on 2/22/2017.
 */
public class ValidBST {
  public boolean isValidBST(TreeNode root) {
    /**
     * here must be (long)Integer.MIN_VALUE-1, could not be (long)(Integer.MIN_VALUE-1), because when (Integer.MIN_VALUE-1),
     * it still use int calculation, so int overflow to convert to a positive number, then cast to long
     */
    return isValidBST(root, (long) Integer.MIN_VALUE - 1, (long) Integer.MAX_VALUE + 1);
  }

  public boolean isValidBST(TreeNode root, long min, long max) {
    if (root==null)
      return true;
    /**
     * must have =, could not only < or >, for example, [1, 1]
     */
    if (root.val<=min || root.val>=max)
      return false;
    return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
  }
}
