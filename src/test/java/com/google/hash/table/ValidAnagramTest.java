package com.google.hash.table;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 3/22/2017.
 */
public class ValidAnagramTest {
  @Test
  public void isAnagram_hashMap() throws Exception {
    // Given
    ValidAnagram validAnagram = new ValidAnagram();

    // When
    boolean isValidAnagram = validAnagram.isAnagram_hashMap("a", "b");

    assertThat(isValidAnagram, is(Boolean.FALSE));
  }

}