package com.google.string;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 3/14/2017.
 */
public class LongestPalindromicStringTest {
  @Test
  public void longestPalindrome() throws Exception {
    // Given
    LongestPalindromicString lps = new LongestPalindromicString();

    // When
    String res = lps.longestPalindrome("babad");

    // Then
    assertThat(res, is("bab"));
  }

}