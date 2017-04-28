package com.google.bfs.dfs.dfs;

import java.util.List;

import org.junit.Test;

/**
 * Created by ychang on 4/24/2017.
 */
public class RemoveInvalidParenthesesTest {
  @Test
  public void removeInvalidParentheses() throws Exception {
    // Given
    RemoveInvalidParentheses removeInvalidParentheses = new RemoveInvalidParentheses();

    // When
    List<String> strings = removeInvalidParentheses.removeInvalidParentheses("()())()");
  }

}