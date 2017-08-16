package com.google.bfs.dfs.dfs;

/**
 * Created by ychang on 2/21/2017.
 */
public class PopulatingNextRightPointers {
  public void connect_recursive(TreeLinkNode root) {
    if (root==null || (root.left==null && root.right==null)) return;
    root.left.next=root.right;
    root.right.next=root.next==null ? null : root.next.left;
    connect_recursive(root.left);
    connect_recursive(root.right);
  }

  public void connect_iteratively(TreeLinkNode root) {
    while (root!=null) {
      // each level
      TreeLinkNode p = root;
      // loop all nodes in this level
      while (p!=null && p.left!=null) {
        p.left.next = p.right;
        p.right.next = p.next== null ? null : p.next.left;
        p=p.next;
      }
      root=root.left;
    }
  }
}

class TreeLinkNode{
  int val;
  TreeLinkNode left, right, next;
  TreeLinkNode(int x) { val = x; }
}
