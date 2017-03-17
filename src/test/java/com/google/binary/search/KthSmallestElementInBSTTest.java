package com.google.binary.search;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

/**
 * Created by ychang on 1/27/2017.
 */
public class KthSmallestElementInBSTTest {
  KthSmallestElementInBST kthSmallestElementInBST = new KthSmallestElementInBST();

  @Test
  public void kthSmallest_recursive() throws Exception {
    // Given
    TreeNode node_2 = new TreeNode(2);
    TreeNode node_1 = new TreeNode(1);
    node_2.left = node_1;

    // When
    int i = kthSmallestElementInBST.kthSmallest_stack(node_2, 1);

    // Then
    assertThat(i, is(1));
  }

}