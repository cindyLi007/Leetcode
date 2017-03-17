package com.google.two.pointers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 2/16/2017.
 */
public class MoveZeroesTest {
  @Test
  public void moveZeroes() throws Exception {
    // Given
    int[] array = new int[]{0, 1, 0, 3, 12};
    MoveZeroes moveZeroes = new MoveZeroes();

    // When
    moveZeroes.moveZeroes(array);

    // Then
    assertThat(array, is(new int[]{1, 3, 12, 0, 0}));
  }

}