package com.google.bfs.dfs.dfs;

/**
 * Created by ychang on 2/21/2017.
 */
public class PopulatingNextRightPointerII {
  public void connect(TreeLinkNode root) {
    while (root!=null) {
      TreeLinkNode p = root;
      TreeLinkNode cur=null, firstChild=null;
      while (p!=null) {
        if (p.left!=null) {
          if (cur!=null) {
            cur.next=p.left;
          } else {
            firstChild=p.left;
          }
          cur=p.left;
        }
        if (p.right!=null) {
          if (cur!=null) {
            cur.next=p.right;
          } else {
            firstChild=p.right;
          }
          cur=p.right;
        }
        p=p.next;
      }
      // go to next level
      root=firstChild;
    }
  }
}
