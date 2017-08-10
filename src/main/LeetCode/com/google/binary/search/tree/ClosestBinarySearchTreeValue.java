package com.google.binary.search.tree;

/**
 * Created by ychang on 7/20/2017.
 */
public class ClosestBinarySearchTreeValue {
  public int closestValue(TreeNode root, double target) {
    TreeNode kid = target>root.val ? root.right : root.left;
    if (kid==null)
      return root.val;
    int b = closestValue(kid, target);
    return Math.abs(root.val - target)<Math.abs(b - target) ? root.val : b;
  }

  public int closestValue_iterative(TreeNode root, double target) {
    /**
     * IMPORTANT: MUST use double to record minDiff to avoid loss conversion from double to int
     */
    double min=Double.MAX_VALUE;
    int res=root.val;
    while (root!=null) {
      if (Math.abs(root.val-target) < min) {
        res=root.val;
        min=Math.abs(root.val-target);
      }
      if (target<root.val) root=root.left;
      else root=root.right;
    }
    return res;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(Integer.MAX_VALUE);
    root.left = new TreeNode(Integer.MIN_VALUE);
    ClosestBinarySearchTreeValue closestBinarySearchTreeValue = new ClosestBinarySearchTreeValue();

    int res = closestBinarySearchTreeValue.closestValue(root, 150000000.342);

    System.out.println(res);
  }
}

class TreeNode {
  TreeNode left, right;
  int val;

  TreeNode(int v) {
    val = v;
  }
}
