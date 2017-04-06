package com.google.string;

import java.util.List;

import org.junit.Test;

/**
 * Created by ychang on 3/29/2017.
 */
public class FlipGameTest {
  @Test
  public void generatePossibleNextMoves_abstract() throws Exception {
    // Given
    FlipGame flipGame = new FlipGame();

    // When
    List<String> strings = flipGame.generatePossibleNextMoves_abstract("---+");

  }

}