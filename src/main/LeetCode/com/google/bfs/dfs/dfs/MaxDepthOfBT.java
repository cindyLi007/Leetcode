package com.google.bfs.dfs.dfs;

/**
 * Created by ychang on 2/21/2017.
 */
public class MaxDepthOfBT {
  public int maxDepth(TreeNode root) {
    return depth(root, 0);
  }

  private int depth(TreeNode root, int depth) {
    if (root==null) return depth;
    return Math.max(depth(root.left, depth+1), depth(root.right, depth+1));
  }
}
