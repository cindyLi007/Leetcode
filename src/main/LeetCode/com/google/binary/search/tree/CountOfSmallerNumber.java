package com.google.binary.search.tree;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ychang on 2/1/2017.
 */
public class CountOfSmallerNumber {
  public List<Integer> countSmaller(int[] nums) {
    /**
     * Must be Integer[] instead of int[], otherwise could not use Arrays.asList to convert to List<Integer>
     */
    Integer[] res = new Integer[nums.length];
    TreeNode root = null;
    for (int i = nums.length - 1; i>=0; i--) {
      /**
       * IMPORTANT, root is null, so we must set the return value of insert method to root, otherwise, next round, root
       * is still null.
       */
      root = insert(root, nums[i], i, res, 0);
    }
    return Arrays.asList(res);
  }

  private TreeNode insert(TreeNode node, int v, int index, Integer[] res, int preSum) {
    if (node==null) {
      /**
       * we must first set smaller to 0 for a new node, because we only count all nodes directly in its left,
       * not inherit from its parent to avoid duplicated count
       */
      node = new TreeNode(0, v);
      res[index] = preSum;
    } else if (node.val==v) {
      node.dup++;
      res[index] = preSum + node.smaller;
    } else if (node.val<v) {
      node.right = insert(node.right, v, index, res, preSum + node.dup + node.smaller);
    } else {
      node.smaller++;
      node.left = insert(node.left, v, index, res, preSum);
    }
    return node;
  }

  class TreeNode {
    TreeNode left, right;
    /**
     * https://discuss.leetcode.com/topic/31405/9ms-short-java-bst-solution-get-answer-when-building-bst
     * 1(0, 1)
     * \
     * 6(3, 1)
     * /
     * 2(0, 2)
     * \
     * 3(0, 1)
     * smaller recording the total of number on it's left bottom side. So when insert a new node, can directly use this
     * number. smaller and dup change even after pass this node
     * dup is how many elements have this value
     */
    int smaller, val, dup;

    TreeNode(int s, int v) {
      smaller = s;
      val = v;
      dup = 1;
    }
  }
}
