package com.google.Tree;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 9/26/2017.
 */
public class DiameterOfBTTest {
  @Test
  public void diameterOfBinaryTree() throws Exception {
    // Given
    DiameterOfBT diameterOfBT = new DiameterOfBT();
    TreeNode root = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    node3.left = new TreeNode(4);
    node2.left = node3;
    root.left = node2;

    // When
    int diameterOfBinaryTree = diameterOfBT.diameterOfBinaryTree(root);

    // Then
    assertThat(diameterOfBinaryTree, is(3));
  }

}