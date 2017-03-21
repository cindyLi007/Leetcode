package com.google.Tree;

import org.junit.Test;

/**
 * Created by ychang on 3/20/2017.
 */
public class LowestCommonAncestorBSTTest {
  @Test
  public void nextValue() throws Exception {
    TreeNode root = new TreeNode(5);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node8 = new TreeNode(8);
    TreeNode node7 = new TreeNode(7);
    TreeNode node9 = new TreeNode(9);
    root.left = node3;
    root.right = node8;
    node3.left=node2;
    node3.right=node4;
    node8.left=node7;
    node8.right=node9;

    LowestCommonAncestorBST lowestCommonAncestorBST = new LowestCommonAncestorBST();
    int i = lowestCommonAncestorBST.nextValue(root, 7);

    System.out.println(i);
  }

}