package com.google.string;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 8/9/2017.
 */
public class CompareVersionTest {
  @Test
  public void compareVersion() throws Exception {
    // Given
    CompareVersion compareVersion = new CompareVersion();

    // When
    int res = compareVersion.compareVersion("01", "1");

    // Then
    assertThat(res, is(0));
  }

}