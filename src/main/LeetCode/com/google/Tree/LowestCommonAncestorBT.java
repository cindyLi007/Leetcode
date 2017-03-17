package com.google.Tree;

/**
 * Created by ychang on 3/12/2017. We suppose p, q must in the Tree
 */
public class LowestCommonAncestorBT {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    /**
     * base case, if we found at least one or hit null node.
     * Because the assumption that p, q must in the Tree, when we find one node in a subtree, we need not confirm whether
     * the other one is in the subtree, because we will check the peer left/right tree.(if p/q not in that peer left/right
     * tree, we know all nodes in this subtree)
     */
    if (root==null || root==q || root==p)
      return root;
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    // one node in left and one node in right
    if (left!=null && right!=null)
      return root;
    return left==null ? right : left;
  }
}
