package com.google.bfs.dfs.dfs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 2/21/2017.
 */
public class BTMaximumPathSumTest {
  @Test
  public void maxPathSum() throws Exception {
    // Given
    TreeNode root = new TreeNode(-2);
    root.left = new TreeNode(-1);
    BTMaximumPathSum btMaximumPathSum = new BTMaximumPathSum();

    // When
    int res = btMaximumPathSum.maxPathSum(root);

    // Then
    assertThat(res, is(-1));
  }

}