package com.google.Tree;

/**
 * Created by ychang on 3/12/2017. We supposed p, q must in the Tree
 */
public class LowestCommonAncestorBST {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root==null)
      return null;
    if (root==p || root==q)
      return root;
    int max = Math.max(p.val, q.val), min = Math.min(p.val, q.val);
    if (max<root.val)
      return lowestCommonAncestor(root.left, p, q);
    if (min>root.val)
      return lowestCommonAncestor(root.right, p, q);
    return root;
  }

  public int nextValue(TreeNode root, int value) {
    if (root==null) return Integer.MIN_VALUE;
    if (root.val<=value) {
      return nextValue(root.right, value);
    }
    int left = nextValue(root.left, value);
    if (left==Integer.MIN_VALUE) return root.val;
    return left;
  }

}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}
