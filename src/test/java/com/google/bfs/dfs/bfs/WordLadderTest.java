package com.google.bfs.dfs.bfs;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

/**
 * Created by ychang on 3/21/2017.
 */
public class WordLadderTest {
  @Test
  public void ladderLength() throws Exception {
    // Given
    WordLadder wordLadder = new WordLadder();

    // When
    wordLadder.ladderLength("hit", "cog", new LinkedList<>(Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"})));


  }

}