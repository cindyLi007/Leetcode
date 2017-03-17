package com.google.hash.table;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 2/7/2017.
 */
public class HappyNumberTest {
  @Test
  public void isHappy() throws Exception {
    // Given

    HappyNumber happyNumber = new HappyNumber();

    // When
    boolean happy = happyNumber.isHappy_best(2);

    // Then
    assertThat(happy, is(Boolean.TRUE));
  }

}