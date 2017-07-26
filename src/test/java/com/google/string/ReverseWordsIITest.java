package com.google.string;

import org.junit.Test;

/**
 * Created by ychang on 7/23/2017.
 */
public class ReverseWordsIITest {
  @Test
  public void reverseWords() throws Exception {
    // Given
    ReverseWordsII reverseWordsII = new ReverseWordsII();

    // When
    char[] s = new char[]{'a', ' ', 'b'};
    reverseWordsII.reverseWords(s);

    // Then(
    System.out.println(s);
  }

  @Test
  public void test_reverseWords() {
    // Given
    ReverseWordsII reverseWordsII = new ReverseWordsII();

    // When
    String s = reverseWordsII.reverseWords_woSplit("1 ");
  }

}