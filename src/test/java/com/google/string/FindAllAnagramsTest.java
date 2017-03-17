package com.google.string;

import java.util.List;

import org.junit.Test;

/**
 * Created by ychang on 3/14/2017.
 */
public class FindAllAnagramsTest {
  @Test
  public void findAnagrams() throws Exception {
    // Given
    FindAllAnagrams findAllAnagrams = new FindAllAnagrams();

    // When
    List<Integer> anagrams = findAllAnagrams.findAnagrams("waaabaebabacd", "abcd");
  }

}