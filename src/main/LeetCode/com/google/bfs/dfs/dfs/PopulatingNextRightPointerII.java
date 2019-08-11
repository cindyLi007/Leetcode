package com.google.bfs.dfs.dfs;

/**
 * Created by ychang on 2/21/2017.
 */
public class PopulatingNextRightPointerII {
  // Time: O(N), Space: O(1)
  public TreeLinkNode connect_iterate(TreeLinkNode root) {
    TreeLinkNode tree = root;
    while (root!=null) {
      root = populateLowerLevelNextField(root);
    }
    return tree;
  }

  private TreeLinkNode populateLowerLevelNextField(TreeLinkNode root) {
    TreeLinkNode first = null, prev = null;
    while (root!=null) {
        if (root.left!=null) {
          if (first==null)  {
            first = root.left;
            prev = root.left;
          } else {
            prev.next = root.left;
            prev = root.left;
          }
        }
        if (root.right!=null) {
          if (first==null)  {
            first = root.right;
            prev = root.right;
          } else {
            prev.next = root.right;
            prev = root.right;
          }
        }
        root = root.next;
      }
      return first;
    }

  // Time: O(N), Space: O(1)
  public TreeLinkNode connect(TreeLinkNode root) {
    if (root==null || root.left==null && root.right==null) return root;
    TreeLinkNode node = root;

    // retrive the next right node close to root.subtrees, this node will be used for root.left/right node
    TreeLinkNode next = root.next;
    while (next!=null && next.left==null && next.right==null) next = next.next;
    if (next!=null) next = next.left==null ? next.right : next.left;

    if (root.left!=null) root.left.next = root.right==null ? next : root.right;
    if (root.right!=null) root.right.next = next;

    // must first go to right, then go to left, that is because left need use right's result
    connect(root.right);
    connect(root.left);

    return node;
  }
}
