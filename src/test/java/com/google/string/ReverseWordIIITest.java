package com.google.string;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReverseWordIIITest {

  @Test
  public void reverseWords() {
    // Given
    ReverseWordIII reverseWordIII = new ReverseWordIII();

    // When
    String reverseWords = reverseWordIII.reverseWords("Let's take LeetCode contest");

    // Then
    assertThat(reverseWords, is("s'teL ekat edoCteeL tsetnoc"));
  }
}