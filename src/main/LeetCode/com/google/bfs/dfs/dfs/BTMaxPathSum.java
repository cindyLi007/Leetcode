package com.google.bfs.dfs.dfs;

/**
 * Created by ychang on 2/22/2017.
 * A recursive method maxPath(TreeNode node) (1) computes the maximum path sum with highest node is the input node, update maximum if necessary
 * (2) returns the maximum sum of the path that can be extended to input node's parent.
 */
public class BTMaxPathSum {
  int maxPathSum;

  public int maxPathSum(TreeNode root) {
    maxPathSum=Integer.MIN_VALUE;
    maxPath(root);
    return maxPathSum;
  }

  private int maxPath(TreeNode root) {
    // base case
    if (root==null) return 0;
    // maxPath(left/right) return the path sum value which include node left/right, if the value is less than 0, we ignore it
    int left = Math.max(0, maxPath(root.left));
    int right = Math.max(0, maxPath(root.right));
    // we compare the the path sum which input node is highest node and include left and right with current maxPathSum,
    // in this way, we track the max path sum in any path
    maxPathSum = Math.max(maxPathSum, left+right+root.val);
    // return the value of path which either left or right + root node which can extend with root.parent
    return Math.max(left, right) + root.val;
  }

  /* another write style, same way
  private int maxPath(TreeNode root) {
    if (root==null) return 0;
    // LV and RV is the max value of path througth root.left or root.right,
    // notice: if LV/RV < 0 them will cast to 0 before return, which means ignore the sum from them
    int LV = maxPath(root.left);
    int RV = maxPath(root.right);
    int v = Math.max(LV, RV) + root.val;
    // LV + RV + root.val is the max Path of tree which root is node "root"
    // notice: since we guarantee LV/RV>=0, LV+RV+root.val >= v
    max = Math.max(max, LV + RV + root.val);
    return v>0 ? v : 0;
  } */
}
