package com.google.Tree;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PathSumIIITest {

  @Test
  public void pathSum() {
    // Given
    PathSumIII pathSumIII = new PathSumIII();
    TreeNode root = new TreeNode(10);
    TreeNode left_1 = new TreeNode(5);
    TreeNode right_1 = new TreeNode(-3);
    root.left = left_1;
    root.right = right_1;
    TreeNode left_2 = new TreeNode(3);
    TreeNode right_21 = new TreeNode(2);
    TreeNode right_22 = new TreeNode(11);
    left_1.left = left_2;
    left_1.right = right_21;
    right_1.right = right_22;
    TreeNode left_3 = new TreeNode(3);
    TreeNode right_31 = new TreeNode(-2);
    TreeNode right_32 = new TreeNode(1);
    left_2.left = left_3;
    left_2.right = right_31;
    right_21.right = right_32;

    // When
    int sum = pathSumIII.pathSum(root, 6);

    // Then
    assertThat(sum, is(2));
  }
}