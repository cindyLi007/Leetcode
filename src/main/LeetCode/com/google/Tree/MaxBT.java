package com.google.Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by grchan on 7/27/2018
 * Leetcode 654
 */
public class MaxBT {
  /*
  Time: O(N*h), worst case is a natural order array, it is same idea as stack.
   */
  public TreeNode constructMaximumBinaryTree_2(int[] nums) {
    TreeNodeWithParent root = new TreeNodeWithParent(nums[0]);
    TreeNodeWithParent prev = root;
    for (int i=1; i<nums.length; i++) {
      TreeNodeWithParent cur = new TreeNodeWithParent(nums[i]);
      if (nums[i]<nums[i-1]) {
        prev.right = cur;
        cur.parent = prev;
      } else {
        TreeNodeWithParent temp = prev;
        while (prev!=null && prev.val<cur.val) {
          temp=prev;
          prev=prev.parent;
        }
        cur.left = temp;
        cur.parent = prev;
        temp.parent = cur;
        if (prev!=null) {
          prev.right = cur;
        }
        if (cur.parent==null) {
          root=cur;
        }
      }
      prev = cur;
    }
    return build(root);
  }

  // Time: O(n^2)
  public TreeNode constructMaximumBinaryTree_1(int[] nums) {
    return construct(nums, 0, nums.length-1);
  }

  private TreeNode construct(int[] nums, int l, int h) {
    if (l>h) return null;
    if (l==h) return new TreeNode(nums[l]);

    // find the maxIdx, O(N)
    int maxIdx = l;
    for (int i=l+1; i<=h; i++) {
      if (nums[i]>nums[maxIdx]) {
        maxIdx = i;
      }
    }

    TreeNode root = new TreeNode(nums[maxIdx]);
    root.left = construct(nums, l, maxIdx-1);
    root.right = construct(nums, maxIdx+1, h);
    return root;
  }

  private TreeNode build(TreeNodeWithParent root) {
    if (root==null) return null;
    TreeNode root_1 = new TreeNode(root.val);
    root_1.left = build(root.left);
    root_1.right = build(root.right);
    return root_1;
  }

  private class TreeNodeWithParent {
    int val;
    TreeNodeWithParent left, right, parent;
    TreeNodeWithParent(int x) { val = x; }
  }

  // Time: O(N), Space: O(h), O(N) for worst case skewed tree
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    Deque<TreeNode> stack = new LinkedList<>();
    for(int i = 0; i < nums.length; i++) {
      TreeNode curr = new TreeNode(nums[i]);
      while (!stack.isEmpty() && stack.peek().val < nums[i]) {
        curr.left = stack.pop();
      }
      if (!stack.isEmpty()) {
        stack.peek().right = curr;
      }
      stack.push(curr);
    }

    return stack.isEmpty() ? null : stack.removeLast();
  }
}
