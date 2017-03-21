package com.google.Tree;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 3/19/2017.
 */
public class FindBottomLeftTreeValueTest {
  @Test
  public void findBottomLeftValue_BFS() throws Exception {
    // Given
    FindBottomLeftTreeValue findBottomLeftTreeValue = new FindBottomLeftTreeValue();
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);

    // When
    int res = findBottomLeftTreeValue.findBottomLeftValue_BFS(root);

    // Then
    assertThat(res, is(1));
  }

}