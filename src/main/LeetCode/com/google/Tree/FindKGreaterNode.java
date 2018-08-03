package com.google.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by grchan on 7/30/2018
 * Given a BST root node, a target value, find K nodes in the BST which are most greater-closed to target in order
 *        50
 *      /    \
 *     30    60
 *    / \   / \
 *  10  35 55 80
 *
 * target is 34, k is 3, should return 35, 50, 55
 */
public class FindKGreaterNode {

  // Time: O(lgN + K), Space: O(lgN)
  public List<Integer> findKGreaterNode(TreeNode root, int target, int k) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    // first find the most closed greater node and stack all greater-than nodes in stack
    while (root!=null) {
      if (root.val>=target) {
        stack.push(root);
        root=root.left;
      } else {
        root=root.right;
      }
    }
    // inorder traverse the tree from the most closed greater node
    while ((!stack.isEmpty() || root!=null) && res.size()<k) {
      if (root==null) {
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

  public List<Integer> findKGreaterNodeRecursive(TreeNode root, int target, int k) {
    List<Integer> res = new ArrayList<>();
    if (root==null || k==0) return res;
    if (root.val>target) {
      List<Integer> leftList = findKGreaterNodeRecursive(root.left, target, k);
      res.addAll(leftList);
    }
    if (res.size()==k) return res;
    if (root.val>=target) {
      res.add(root.val);
    }
    List<Integer> right = findKGreaterNodeRecursive(root.right, target, k - res.size());
    res.addAll(right);
    return res;
  }
}
