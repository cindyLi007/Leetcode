package com.google.bfs.dfs.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ychang on 2/21/2017.
 */
public class SymmetricTree {
  /**
   * DFS
   */
  public boolean isSymmetric_recursive(TreeNode root) {
    if (root==null)
      return true;
    return isSymmetric(root.left, root.right);
  }

  private boolean isSymmetric(TreeNode left, TreeNode right) {
    if (left==null && right==null)
      return true;
    if (left==null || right==null || left.val!=right.val)
      return false;
    return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
  }

  /**
   * BFS
   */
  public boolean isSymmetric_iteratively(TreeNode root) {
    if (root==null) return true;
    Queue<TreeNode> leftQueue = new LinkedList<>();
    Queue<TreeNode> rightQueue = new LinkedList<>();
    leftQueue.add(root.left);
    rightQueue.add(root.right);
    while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
      TreeNode left = leftQueue.poll();
      TreeNode right = rightQueue.poll();
      if (left==null && right==null) continue;
      if (left==null || right==null || left.val!=right.val) return false;
      leftQueue.offer(left.left);
      leftQueue.offer(left.right);
      rightQueue.offer(right.right);
      rightQueue.offer(right.left);
    }
    return (leftQueue.isEmpty() && rightQueue.isEmpty());
  }
}

class TreeNode {
  int val;
  TreeNode left, right;

  TreeNode(int x) {
    val = x;
  }
}
