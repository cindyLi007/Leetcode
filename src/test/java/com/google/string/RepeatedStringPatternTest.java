package com.google.string;

import static java.lang.Boolean.TRUE;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by ychang on 1/5/2017.
 */
public class RepeatedStringPatternTest {
  RepeatedStringPattern rsp;

  @Before
  public void setUp() throws Exception {
    rsp = new RepeatedStringPattern();
  }

  @Test
  public void repeatedSubstringPattern() throws Exception {
    // Given
    String s = "abcabcabcabc";

    // When
    boolean res = rsp.repeatedSubstringPattern(s);

    // Then
    assertThat(res, is(TRUE));
  }

}