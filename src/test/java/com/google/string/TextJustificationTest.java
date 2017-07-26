package com.google.string;

import java.util.List;

import org.junit.Test;

/**
 * Created by ychang on 6/4/2017.
 */
public class TextJustificationTest {
  @Test
  public void fullJustify() throws Exception {
    // Given
    TextJustification textJustification = new TextJustification();
    String[] words = new String[]{"Here","is","an","example","of","text","justification."};

    // When
    List<String> strings = textJustification.fullJustify(words, 16);

    strings.stream().forEach(System.out::println);
  }

}