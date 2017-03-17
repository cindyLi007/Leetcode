package com.google.binary.search;

import java.util.Stack;

/**
 * Created by ychang on 1/27/2017.
 */
public class KthSmallestElementInBST {
  // beat 48%
  public int kthSmallest_Count(TreeNode root, int k) {
    int count = count(root.left);
    if (count==k - 1) { // base case
      return root.val;
    }
    if (count<(k - 1)) {
      return kthSmallest_Count(root.right, k - count - 1);
    }
    return kthSmallest_Count(root.left, k);
  }

  private int count(TreeNode root) {
    if (root==null) {
      return 0;
    }
    return count(root.left) + 1 + count(root.right);
  }

  // beat 21%
  public int kthSmallest_stack(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack();
    while (root!=null) {
      stack.push(root);
      root = root.left;
    }
    while (k!=0) {
      TreeNode top = stack.pop();
      k--;
      if (k==0)
        return top.val;
      top = top.right;
      while (top!=null) {
        stack.push(top);
        top = top.left;
      }
    }
    return -1;
  }

}

class TreeNode {
  int val;
  TreeNode left, right;

  TreeNode(int x) {
    val = x;
  }
}
