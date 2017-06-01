package com.google.stack;

import java.util.Stack;

/**
 * Created by ychang on 1/24/2017.
 * next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * We could not first traverse the whole tree and save values in a list. Remember iterator is just a pointer to stop in
 * a position of the tree. We should save nodes in a stack. Any time, the top of the stack is the node which holds the
 * smallest value. When push, only push left side of each node. When pop, push current node's right side to stack.
 * This question is very similar with In-order Traverse BST
 */
public class BSTIterator {
  TreeNode cur;
  Stack<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    cur=root;
    stack=new Stack();
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return cur!=null || !stack.isEmpty();
  }

  /** @return the next smallest number */
  public int next() {
    while (cur!=null) {
      stack.push(cur);
      cur=cur.left;
    }
    TreeNode next = stack.pop();
    cur=next.right;
    return next.val;
  }

  public class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
      val = x;
    }
  }
}
