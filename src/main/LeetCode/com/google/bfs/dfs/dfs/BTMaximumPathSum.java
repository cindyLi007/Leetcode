package com.google.bfs.dfs.dfs;

/**
 * Created by ychang on 2/21/2017.
 */
public class BTMaximumPathSum {
  public int maxPathSum(TreeNode root) {
    if (root==null) return Integer.MIN_VALUE;
    if (root.left==null && root.right==null) return root.val;
    int left = maxPathSum(root.left, root.val);
    int right = maxPathSum(root.right, root.val);
    int res;
    int min = Math.min(left, right), max = Math.max(left, right);
    if (max<0) res=Math.max(root.val, max);
    else res=max+ (min-root.val<0 ? 0 : min-root.val);
    return Math.max(Math.max(maxPathSum(root.left), maxPathSum(root.right)), res);
  }

  private int maxPathSum(TreeNode root, int sum) {
    if (root==null) return sum;
    if (root.left==null && root.right==null) return root.val<0 ? sum : sum+root.val;
    int left = maxPathSum(root.left, sum+root.val), right= maxPathSum(root.right, sum+root.val);
    int max=Math.max(left, right), min=Math.min(left, right);
    if (max<0) return sum;
    return max;
  }
}
