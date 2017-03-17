package com.google;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

import com.google.hash.table.LongestSubstring;

/**
 * Created by ychang on 2/7/2017.
 */
public class LongestSubstringTest {

  @Test
  public void lengthOfLongestSubstring() throws Exception {
    // Given
    LongestSubstring longestSubstring = new LongestSubstring();

    // When
    int res = longestSubstring.lengthOfLongestSubstring("pwwkew");

    // Then
    assertThat(res, is(3));
  }

}