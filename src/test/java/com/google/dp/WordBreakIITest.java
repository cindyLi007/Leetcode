package com.google.dp;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Created by ychang on 3/8/2017.
 */
public class WordBreakIITest {
  @Test
  public void wordBreak() throws Exception {
    // Given
    List<String> list = Arrays.asList("cat", "cats", "and", "sand", "dog");
    WordBreakII wordBreakII = new WordBreakII();

    // When
    List<String> res = wordBreakII.wordBreak("catsanddog", list);

    // Then
  }

}