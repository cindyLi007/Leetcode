package com.google.string;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 4/28/2017.
 */
public class MinWindowSubstringTest {
  @Test
  public void minWindow() throws Exception {
    // Given
    MinWindowSubstring minWindowSubstring = new MinWindowSubstring();

    // When
    String minWindow = minWindowSubstring.minWindow("cabwefgewcwaefgcf", "cae");

    // Then
    assertThat(minWindow, is("cwae"));
  }

}