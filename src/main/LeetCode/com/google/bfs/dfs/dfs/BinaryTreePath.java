package com.google.bfs.dfs.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ychang on 2/22/2017.
 */
public class BinaryTreePath {
  // top-down recursive, beat 92%
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList();
    if (root!=null) traverse(root, res, "");
    return res;
  }

  private void traverse(TreeNode root, List<String> res, String prefix){
    if (root.left==null && root.right==null) {
      res.add(prefix+root.val);
    } else {
      if (root.left!=null) {
        traverse(root.left, res, prefix+root.val+"->");
      }
      if (root.right!=null) {
        traverse(root.right, res, prefix+root.val+"->");
      }
    }
  }

  // bottom-up recursive, beat 39%
  public List<String> binaryTreePaths_bottomUp(TreeNode root) {
    List<String> res = new ArrayList();
    if (root==null) return res;
    List<String> list = binaryTreePaths(root.left);
    list.addAll(binaryTreePaths(root.right));
    if (list.size()==0) {
      res.add(root.val+"");
    } else {
      for (String str : list) {
        res.add(root.val + "->" + str);
      }
    }
    return res;
  }
}

