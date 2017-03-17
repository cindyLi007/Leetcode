package com.google;

import static java.lang.Integer.max;

public class BinaryTreeLongestConsecutiveSequence {
  public int longestConsecutive(TreeNode root) {
    if (root == null) return 0;
    int leftNum = longestConsecutive(root.left, root.val, 1);
    int rightNum = longestConsecutive(root.right, root.val, 1);
    return max(leftNum, rightNum);
  }

  public int longestConsecutive(TreeNode root, int prev, int path) {
    if (root == null) return path;
    if (prev + 1 == root.val) path++;
    else path = 1;
    int leftNum = longestConsecutive(root.left, root.val, path);
    int rightNum = longestConsecutive(root.right, root.val, path);
    return max(path, max(leftNum, rightNum));
  }

  public static void main(String[] args) {
    BinaryTreeLongestConsecutiveSequence instance = new BinaryTreeLongestConsecutiveSequence();
    TreeNode node_1 = new TreeNode(1);
    TreeNode node_2 = new TreeNode(2);
    TreeNode node_3 = new TreeNode(3);
    TreeNode node_4 = new TreeNode(4);
    TreeNode node_5 = new TreeNode(5);
    node_1.right = node_3;
    node_1.left = node_2;
    node_2.left = node_4;
    node_2.right = node_5;
    /*node_3.left = node_2; node_3.right = node_4;
    node_4.right = node_5; */
    int result = instance.longestConsecutive(node_1);
    /*node_2.right = node_3;
    node_3.left = node_4;
    node_4.left = node_1;
    int result = instance.longestConsecutive(node_2);*/

    System.out.println("the longest consecutive sequence is " + result);
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}
