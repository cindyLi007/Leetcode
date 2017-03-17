package com.google.binary.search;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

/**
 * Created by ychang on 1/27/2017.
 */
public class GuessNumberTest {
  GuessNumber guessNumber = new GuessNumber();

  @Test
  public void guessNumber() throws Exception {
    // Given
    int n=2126753390;

    // When
    int res = guessNumber.guessNumber(n);

    // then
    assertThat(res, is(1702766719));
  }

}