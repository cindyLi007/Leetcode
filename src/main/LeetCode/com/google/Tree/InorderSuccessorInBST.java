package com.google.Tree;

/**
 * Created by ychang on 5/3/2017.
 */
public class InorderSuccessorInBST {
  // this can beat 59%
  public TreeNode inorderSuccessor_iterative(TreeNode root, TreeNode p) {
    TreeNode suc = null;
    while (root!=null) {
      if (p.val<root.val) {
        suc = root;
        root = root.left;
      } else {
        root = root.right;
      }
    }
    return suc;
  }

  // this can beat 28%
  public TreeNode inorderSuccessor_recursive(TreeNode root, TreeNode p) {
    if (root==null)
      return null;
    if (root.val<=p.val) {
      return inorderSuccessor_recursive(root.right, p);
    } else {
      TreeNode temp = inorderSuccessor_recursive(root.left, p);
      return (temp==null) ? root : temp;
    }
  }
}
