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
    Integer[] ans = new Integer[nums.length];
    TreeNode root = null;
    for (int i = nums.length - 1; i>=0; i--) {
      /**
       * IMPORTANT, root is null, so we must set the return value of insert method to root, otherwise, next round, root
       * is still null.
       */
      insert(root, nums[i], ans, i, 0);
    }
    return Arrays.asList(ans);
  }

  private TreeNode insert(TreeNode root, int value, Integer[] ans, int index, int sum) {
    if (root==null) {
      root = new TreeNode(0, value);
      ans[index] = sum;
    } else if (root.val==value) {
      root.dup++;
      ans[index] = root.smaller + sum;
    } else if (root.val>value) { // left
      root.smaller++;
      root.left = insert(root.left, value, ans, index, sum);
    } else { //right
      root.right = insert(root.right, value, ans, index, root.dup + root.smaller + sum);
    }
    return root;
  }

  class TreeNode {
    TreeNode left, right;
    /**
     * https://discuss.leetcode.com/topic/31405/9ms-short-java-bst-solution-get-answer-when-building-bst
         1(0, 1)
         \
         6(3, 1)
         /
         2(0, 2)
         \
         3(0, 1)
     * smaller recording the total of number on it's left bottom side. So when insert a new node, can directly use this
     * number. smaller and dup change even after pass this node
     * dup is how many elements have this value
     */
    int smaller, val, dup = 1;

    TreeNode(int s, int v) {
      smaller = s;
      val = v;
    }
  }
}
