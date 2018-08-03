package com.google.Tree;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by grchan on 7/27/2018
 */
public class LargestBSTSubTreeTest {

  @Test
  public void largestBSTSubtree() {
    // Given
    LargestBSTSubTree largestBSTSubTree = new LargestBSTSubTree();
    TreeNode node_3 = new TreeNode(3);
    TreeNode node_2 = new TreeNode(2);
    TreeNode node_4 = new TreeNode(4);
    TreeNode node_1 = new TreeNode(1);
    TreeNode node_5 = new TreeNode(5);
    TreeNode node_7 = new TreeNode(7);
    node_3.left = node_2; node_3.right = node_4;
    node_4.left = node_1; node_4.right = node_5;
//    node_15.right = node_7;

    // When
    int result = largestBSTSubTree.largestBSTSubtree(node_3);

    // Then
    assertThat(result, is(3));
  }
}