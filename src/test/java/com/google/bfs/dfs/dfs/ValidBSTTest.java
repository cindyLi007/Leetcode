package com.google.bfs.dfs.dfs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 2/22/2017.
 */
public class ValidBSTTest {
  @Test
  public void isValidBST() throws Exception {
    // Given
    TreeNode root=new TreeNode(1);
    root.left=new TreeNode(1);
//    root.right=new TreeNode(3);
    ValidBST validBST = new ValidBST();

    // When
    boolean isValid = validBST.isValidBST(root);

    // Then
    assertThat(isValid, is(Boolean.FALSE));
  }

}