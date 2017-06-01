package com.google.dp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 5/12/2017.
 */
public class WildcardMatchingTest {
  @Test
  public void isMatch() throws Exception {
    // Given
    WildcardMatching wildcardMatching = new WildcardMatching();

    // When
    boolean isMatch = wildcardMatching.isMatch("aa", "*");

    // Then
    assertThat(isMatch, is(Boolean.TRUE));
  }

  @Test
  public void isMatch_recursive() throws Exception {
    // Given
    WildcardMatching wildcardMatching = new WildcardMatching();

    // When
    boolean isMatch = wildcardMatching.isMatch_recursive("aa", "*");

    // Then
    assertThat(isMatch, is(Boolean.TRUE));
  }



}