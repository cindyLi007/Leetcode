package com.google.tire;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 5/4/2017.
 */
public class WordDictionaryTest {
  @Test
  public void addWord() throws Exception {
    // Given
    WordDictionary wordDictionary = new WordDictionary();
    String[] words = new String[]{"ran", "rune", "runner", "runs", "add", "adds", "adder", "addee"};
    for (String str : words) wordDictionary.addWord(str);

    // When
    boolean search = wordDictionary.search("add.");

    // Then
    assertThat(search, is(Boolean.TRUE));
  }

}