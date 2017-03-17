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
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}
