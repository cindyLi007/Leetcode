package com.google.Tree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by grchan on 7/27/2018
 */
public class MaxBTTest {

  @Test
  public void constructMaximumBinaryTree() {
    // Given
    MaxBT maxBT = new MaxBT();
    int[] array = {3, 2, 1, 6, 0, 5};

    // Then
    TreeNode treeNode = maxBT.constructMaximumBinaryTree_1(array);
  }
}