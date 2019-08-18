package com.google.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ychang on 1/24/2017.
 * next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * We could not first traverse the whole tree and save values in a list. Remember iterator is just a pointer to stop in
 * a pos of the tree. We should save nodes in a stack. Any time, the top of the stack is the node which holds the
 * smallest value. When push, only push left side of each node. When pop, push current node's right side to stack.
 * This question is very similar with In-order Traverse BST
 */
public class BSTIterator {
  private Stack<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    stack = new Stack();
    while (root!=null) {
      stack.push(root);
      root = root.left;
    }
  }

  /**
   * @return whether we have a next smallest number
   */
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  /**
   * @return the next smallest number
   */
  public int next() {
    TreeNode res = stack.pop();
    TreeNode root = res.right;
    while (root!=null) {
      stack.push(root);
      root = root.left;
    }
    return res.val;
  }

  public class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
      val = x;
    }
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new LinkedList();
    Stack<TreeNode> stack = new Stack();
    while (!stack.isEmpty() || root!=null) {
      if (root==null) { // root.left have done
        root=stack.pop();
        res.add(root.val);
        root=root.right;
      } else {
        stack.push(root);
        root=root.left;
      }
    }
    return res;
  }
}
