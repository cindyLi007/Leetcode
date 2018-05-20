package com.google.string;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AddStringsTest {

  @Test
  public void addStrings() {
    // Given
    AddStrings addStrings = new AddStrings();

    // When
    String s = addStrings.addStrings("5", "408");

    // Then
    assertThat(s, is("413"));
  }
}