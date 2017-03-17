package com.google.dp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Created by ychang on 3/8/2017.
 */
public class WordBreakTest {
  @Test
  public void wordBreak() throws Exception {
    // Given
    List<String> list = Arrays.asList("dog", "s", "gs");
    WordBreak wordBreak = new WordBreak();

    // When
    boolean canBreak = wordBreak.wordBreak("dogs", list);

    // Then
    assertThat(canBreak, is(Boolean.TRUE));
  }

}