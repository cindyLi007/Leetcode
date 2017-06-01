package com.google.DivideAndConquer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.bfs.dfs.ExpressionAddOperator;

/**
 * Created by ychang on 4/29/2017.
 */
public class ExpressionAddOperatorTest {
  @Test
  public void addOperators() throws Exception {
    // Given
    ExpressionAddOperator expressionAddOperator = new ExpressionAddOperator();

    // When
    List<String> strings = expressionAddOperator.addOperators("123", 6);

    // Then
    assertThat(strings, is(Arrays.asList("10-5", "1*0+5")));
  }

}