package com.google.Tree;

/**
 * Created by grchan on 7/27/2018
 * Leetcode 333
 */
public class LargestBSTSubTree {

  // use this global var to track the largest size
  int max=0;

  // O(n) means we only loop very nodes once
  public int largestBSTSubtree(TreeNode root) {
    traverse(root);
    return max;
  }

  private class Result {
    int size;
    int upper, lower;
    // (size, rangeLower, rangeUpper) -- size of current tree, range of current tree [rangeLower, rangeUpper]
    Result(int size, int upper, int lower) {
      this.size = size;
      this.upper = upper;
      this.lower = lower;
    }
  }

  private Result traverse(TreeNode root) {
    if (root==null) {
      return new Result(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    Result left = traverse(root.left);
    Result right = traverse(root.right);
    // when root.val <= the max value of leftTree or root.val >= the min value of rightTree, it means the root subTree is not BST
    if (left.size==-1 || right.size==-1 || root.val<=left.upper || root.val>=right.lower) {
      return new Result(-1, 0, 0);
    }
    int size = left.size + right.size + 1;
    max = Math.max(size, max);
    return new Result(size, Math.max(root.val, right.upper), Math.min(root.val, left.lower));
  }
}
