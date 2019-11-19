package com.google.DivideAndConquer;

import com.google.Tree.ReversePairs_BIT;
import com.google.Tree.ReversePairs_BST_TLE;
import com.google.bfs.dfs.ExpressionAddOperator;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.core.Is.is;

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
    assertThat(strings, hasItems("1*0+5", "10-5"));
  }

  /**
   * Created by ychang on 6/7/2017.
   */
  public static class ReversePairsTest {
    @Test
    public void reversePairs() throws Exception {
      // Given
      ReversePairs_BST_TLE reversePairsBSTTLE = new ReversePairs_BST_TLE();
      int[] array = new int[]{0, 1, 1, 0};
      int i=5;
      System.out.println(i & ((i - 1) ^ i)); // ^ mean xor

      // When
      int reversePairsResult = reversePairsBSTTLE.reversePairs(array);

      System.out.println(reversePairsResult);
    }

    @Test
    public void reversePairs_BIT() throws Exception {
      // Given
      ReversePairs_BIT reversePairsBit = new ReversePairs_BIT();
  //    int[] array = new int[]{1,3,2,3,1};
      int[] array = new int[]{2, 4, 3, 5, 6, 7, 1, 8};
      // When
      int reversePairsResult = reversePairsBit.reversePairs(array);

      assertThat(reversePairsResult, is(5));
    }

  }
}