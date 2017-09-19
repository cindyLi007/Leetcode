package com.google.graph;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 6/6/2017.
 */
public class AlienDictionaryDFSTest {
  @Test
  public void alienOrder() throws Exception {
    // Given
    AlienDictionaryDFS alienDictionaryDFS = new AlienDictionaryDFS();
    String[] words = new String[]{"wrt", "wrf", "er", "ett", "rftt"};

    // When
    String alienOrder = alienDictionaryDFS.alienOrder(words);

    // Then
    assertThat(alienOrder, is("wertf"));
  }

  @Test
  public void alienOrder_BFSTest() throws Exception {
    // Given
    AlienDictionaryBFS alienDictionaryBFS = new AlienDictionaryBFS();
    String[] words = new String[]{"xz", "as", "xa"};

    // When
    String alienOrder = alienDictionaryBFS.alienOrder(words);

    // Then
    assertThat(alienOrder, is("wertf"));
  }

}