package com.google.string;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by ychang on 5/2/2017.
 */
public class RegularExpressionMatchingTest {
  @Test
  public void isMatch() throws Exception {
    // Given
    RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();

    // When
//    boolean result = regularExpressionMatching.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c");
    boolean result = regularExpressionMatching.isMatch_dp("mississ","mis*");

    // Then
    assertThat(result, is(Boolean.FALSE));
  }
}