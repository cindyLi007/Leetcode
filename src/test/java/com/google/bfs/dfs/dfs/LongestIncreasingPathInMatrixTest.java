package com.google.bfs.dfs.dfs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 2/23/2017.
 */
public class LongestIncreasingPathInMatrixTest {
  @Test
  public void longestIncreasingPath() throws Exception {
    // Given
    int[][] array = new int[][]{{7, 8, 9}, {9, 7, 6}, {7, 2, 3}};
    LongestIncreasingPathInMatrix longestIncreasingPathInMatrix = new LongestIncreasingPathInMatrix();

    // When
    int res = longestIncreasingPathInMatrix.longestIncreasingPath(array);

    // Then
    assertThat(res, is(6));
  }

}