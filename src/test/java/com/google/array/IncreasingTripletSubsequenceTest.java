package com.google.array;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 5/24/2017.
 */
public class IncreasingTripletSubsequenceTest {
  @Test
  public void increasingTriplet() throws Exception {
    // Given
    IncreasingTripletSubsequence increasingTripletSubsquence = new IncreasingTripletSubsequence();

    // When
    boolean haveITS = increasingTripletSubsquence.increasingTriplet(new int[]{1, 2, -1, 3});

    // Then
    assertThat(haveITS, is(Boolean.TRUE));
  }

}