package com.google.stack;

import java.util.Stack;

/**
 * Created by ychang on 1/24/2017.
 * next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * We could not first traverse the whole tree and save values in a list. We should save nodes in a stack. Any time, the
 * top of the stack is the node which holds the smallest value. When push, only push left side of each node. When pop,
 * push current node's right side to stack.
 */
public class BSTIterator {
  Stack<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    stack = new Stack<>();
    pushAll(root);
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode top = stack.pop();
    pushAll(top.right);
    return top.val;
  }

  private void pushAll(TreeNode root) {
    while (root!=null) {
      stack.push(root);
      root = root.left;
    }
  }

  public class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
      val = x;
    }
  }
}
