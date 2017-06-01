package com.google.string;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 3/10/2017.
 */
public class IntegerToEnglishWordsTest {
  @Test
  public void numberToWords() throws Exception {
    // Given
    IntegerToEnglishWords integer = new IntegerToEnglishWords();
    int num1=123, num2=12345, num3=1234567, num4=1000;

    // When
    String word4 = integer.numberToWords_reverse(num4);
    String word1 = integer.numberToWords_reverse(num1);
    String word2 = integer.numberToWords(num2);
    String word3 = integer.numberToWords(num3);

    // Then
    assertThat(word1, is("One Hundred Twenty Three"));
    assertThat(word2, is("Twelve Thousand Three Hundred Forty Five"));
    assertThat(word3, is("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"));
    assertThat(word4, is("One Million"));
  }

}