package com.google.string;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 4/24/2017.
 */
public class AddBinaryTest {
  @Test
  public void addBinary() throws Exception {
    // Given
    AddBinary addBinary = new AddBinary();

    // When
    String res = addBinary.addBinary("0", "0");

    // Then
    assertThat(res, is("0"));
  }

}