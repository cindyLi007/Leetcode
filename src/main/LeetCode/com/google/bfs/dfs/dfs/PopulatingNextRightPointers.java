package com.google.bfs.dfs.dfs;

/**
 * Created by ychang on 2/21/2017.
 */
public class PopulatingNextRightPointers {
  public void connect_recursive(TreeLinkNode root) {
    if (root==null) return;
    connect(root.left, root.right);
  }

  private void connect(TreeLinkNode left, TreeLinkNode right) {
    if (left==null) return;
    left.next=right;
    /**
     * the tricky thing is when we go down, we always keep 2 adjacent tree nodes even they do not share some father
     */
    connect(left.left, left.right);
    connect(left.right, right.left);
    connect(right.left, right.right);
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
