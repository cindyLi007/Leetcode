package com.google.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteTreeChecker {
  public boolean isCompleteTree(TreeNode root) {
    if (root==null || isLeaf(root)) return true;
    Queue<TreeNode> queue = new LinkedList();
    queue.offer(root);
    int size = 0;
    while (!queue.isEmpty()) {
      TreeNode cur = queue.poll();
      size++;
      if (isLeaf(cur)) break;
      if (cur.left==null) break;
      queue.offer(cur.left);
      if (cur.right==null) break;
      queue.offer(cur.right);
    }
    size += queue.size();

    int treeSize = treeSize(root);
    return size == treeSize;
  }

  private int treeSize(TreeNode root) {
    if (root==null) return 0;
    if (isLeaf(root)) return 1;
    return treeSize(root.left) + treeSize(root.right) + 1;
  }

  private boolean isLeaf(TreeNode node) {
    return node.left==null && node.right==null;
  }

  public static void main(String... args) {
    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    left.left = new TreeNode(5);
    TreeNode right = new TreeNode(3);
    right.left = new TreeNode(7);
    right.right = new TreeNode(8);
    root.left = left; root.right = right;
    CompleteTreeChecker completeTreeChecker = new CompleteTreeChecker();
    System.out.println(completeTreeChecker.isCompleteTree(root));
  }
}
