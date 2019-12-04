package com.google.Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodes {
  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    List<TreeNode> res = new ArrayList();
    Set<Integer> set = new HashSet();
    for (int i : to_delete) set.add(i);
    helper(root, set, res, true);
    return res;
  }

  private boolean helper(TreeNode root, Set<Integer> set, List<TreeNode> res, boolean d) {
    boolean flag = set.contains(root.val) ? true : false;

    if (d && !set.contains(root.val)) {
      res.add(root);
    }

    if (root.left!=null) {
      if (helper(root.left, set, res, flag)) root.left = null;
    }
    if (root.right!=null) {
      if (helper(root.right, set, res, flag)) root.right=null;
    }
    return flag;
  }

  public static void main(String... args) {
    int[] delete = new int[]{3, 5};
    TreeNode root = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(5);
    TreeNode n6 = new TreeNode(6);
    TreeNode n7 = new TreeNode(7);
    root.left = n2; root.right = n3;
    n2.left = n4; n2.right = n5;
    n3.left = n6; n3.right = n7;
    DeleteNodes deleteNodes = new DeleteNodes();
    List<TreeNode> treeNodes = deleteNodes.delNodes(root, delete);
    treeNodes.stream().forEach(o -> System.out.println(o.val));
  }
}
