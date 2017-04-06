package com.google.binary.search.tree;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

import java.util.List;

import org.junit.Test;

/**
 * Created by ychang on 2/1/2017.
 */
public class CountOfSmallerNumberTest {
  @Test
  public void countSmaller() throws Exception {
    // Given
    CountOfSmallerNumber cosn = new CountOfSmallerNumber();
    int[] array = new int[]{5, 2, 6, 1};

    // When
    List<Integer> list = cosn.countSmaller(array);

    // Then
    assertThat(list, contains(new Integer(2), new Integer(1), new Integer(1), new Integer(0)));

  }

}