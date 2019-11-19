package com.google.two.pointers;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by ychang on 5/6/2017.
 */
public class ValidPalindromeTest {
  @Test
  public void isPalindrome() throws Exception {
    // Given
    ValidPalindrome validPalindrome = new ValidPalindrome();

    // When
    boolean isPalindrome = validPalindrome.isPalindrome_test("A man, a plan, a canal: Panama");

    // Then
    assertThat(isPalindrome, is(Boolean.TRUE));
  }

}