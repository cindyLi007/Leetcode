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

    /**
     * this is a way to strip a string from part of char array
     */
    String test = "Grace will get MicroSoft offer";
    char[] chars = test.toCharArray();
    // output is "e wil", e is chars[4], from it, count_bruteForce 5 to build a string
    System.out.println(new String(chars, 4, 5)); // 4 is offset, and 5 is how many char include

    // When
    String res = lps.longestPalindrome("babad");

    // Then
    assertThat(res, is("bab"));
  }

}