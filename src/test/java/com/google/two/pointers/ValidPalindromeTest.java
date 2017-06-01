package com.google.two.pointers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 5/6/2017.
 */
public class ValidPalindromeTest {
  @Test
  public void isPalindrome() throws Exception {
    // Given
    ValidPalindrome validPalindrome = new ValidPalindrome();

    // When
    boolean isPalindrome = validPalindrome.isPalindrome("a.");

    // Then
    assertThat(isPalindrome, is(Boolean.TRUE));
  }

}