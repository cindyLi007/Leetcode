package com.google.bfs.dfs.dfs;

import java.util.ArrayDeque;
import java.util.Deque;

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
    if (root == null)
      return true;
    /**
     * must have =, could not only < or >, for example, [1, 1]
     */
    if (root.val <= min || root.val >= max)
      return false;
    return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
  }

  /**
   * if an inorder traversal of a binary tree visits keys in sorted order, then that binary tree must be a BST
   * Time: O(N), space: O(h)
   */
  public boolean isValidBST_inorder(TreeNode root) {
    TreeNode prev = null;
    Deque<TreeNode> queue = new ArrayDeque<>();
    while (root != null || !queue.isEmpty()) {
      if (root == null) {
        root = queue.pop();
        if (prev != null && prev.val >= root.val) {
          return false;
        }
        prev = root;
        root = root.right;
      } else {
        queue.push(root);
        root = root.left;
      }
    }
    return true;
  }

  public static class QueueEntry {
    public TreeNode node;
    public Long lower, upper;

    public QueueEntry(TreeNode n, Long l, long u) {
      node = n;
      lower = l;
      upper = u;
    }
  }

  public boolean isValidBST_BFS(TreeNode root) {
    if (root == null) return true;
    Deque<QueueEntry> queue = new ArrayDeque<>();
    queue.add(new QueueEntry(root, (long) Integer.MIN_VALUE - 1, (long) Integer.MAX_VALUE + 1));
    while (!queue.isEmpty()) {
      QueueEntry qe = queue.removeFirst();
      if (qe.node.val >= qe.upper || qe.node.val <= qe.lower) {
        return false;
      }
      if (qe.node.left != null) {
        queue.add(new QueueEntry(qe.node.left, qe.lower, (long) qe.node.val));
      }
      if (qe.node.right != null) {
        queue.add(new QueueEntry(qe.node.right, (long) qe.node.val, qe.upper));
      }
    }
    return true;
  }
}
