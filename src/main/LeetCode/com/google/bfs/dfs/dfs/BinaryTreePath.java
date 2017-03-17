package com.google.bfs.dfs.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 2/22/2017.
 */
public class BinaryTreePath {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> list = new LinkedList();
    if (root!=null) traverse(root, "", list);
    return list;
  }

  private void traverse(TreeNode root, String s, List<String> list) {
    if (root.left==null && root.right==null) {
      list.add(s+root.val);
    }
    if (root.left!=null) {
      traverse(root.left, s+root.val+"->", list);
    }
    if (root.right!=null) {
      traverse(root.right, s+root.val+"->", list);
    }
  }
}
