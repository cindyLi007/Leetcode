package com.google.bfs.dfs.dfs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

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
    String str = "Grace";
    System.out.println(str.matches("grace||Gace"));

    // When
    List<String> strings = removeInvalidParentheses.removeInvalidParentheses("");

    // Then
    assertThat(strings, containsInAnyOrder(""));
  }

}