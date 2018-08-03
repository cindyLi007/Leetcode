package com.google.bfs.dfs.dfs;

/**
 * Created by ychang on 2/22/2017.
 */
public class FlatternBTtoLinkedList {
  public void flatten(TreeNode root) {
    if (root!=null) flat(root);
  }

  private TreeNode flat(TreeNode root) {
    if (root.left==null && root.right==null) return root;
    if (root.left!=null) {
      TreeNode leftTail = flat(root.left);
      leftTail.right = root.right;
      root.right=root.left;
      root.left=null;
      return leftTail.right!=null ? flat(leftTail.right) : leftTail;
    }
    /**
     * since after 1ine 12, we know either left or right is not null or both is not null, if we go line 24, that means
     * left is null, so right must not be null, need NOT to check
     */
    return flat(root.right);
  }
}
