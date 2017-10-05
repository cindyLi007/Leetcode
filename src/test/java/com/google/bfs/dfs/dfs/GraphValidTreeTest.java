package com.google.bfs.dfs.dfs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 9/14/2017.
 */
public class GraphValidTreeTest {
  @Test
  public void validTree() throws Exception {
    // Given
    GraphValidTree graphValidTree = new GraphValidTree();

    // When
    boolean validTree = graphValidTree.validTree(5, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}});

    // Then
    assertThat(validTree, is(Boolean.TRUE));
  }

}