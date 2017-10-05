package com.google.array;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 10/4/2017.
 */
public class RemoveDuplicatedTest {
  @Test
  public void removeDuplicates_II() throws Exception {
    // Given
    RemoveDuplicated removeDuplicated = new RemoveDuplicated();

    // When
    int len = removeDuplicated.removeDuplicates_II(new int[]{1, 2, 2, 2, 3});

    // Then
    assertThat(len, is(4));
  }

}