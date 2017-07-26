package com.google.Tree;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

import com.google.divide.and.conqure.ReversePair;

/**
 * Created by ychang on 6/7/2017.
 */
public class ReversePairsTest {
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

  @Test
  public void reversePairs_merge() {
    // Given
    ReversePair reversePair = new ReversePair();
    int[] array = new int[]{2, 4, 3, 5, 1};

    // When
    int r = reversePair.reversePairs(array);

    // Then
    assertThat(r, is(3));
  }
}