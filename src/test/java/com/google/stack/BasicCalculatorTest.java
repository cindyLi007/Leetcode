package com.google.stack;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BasicCalculatorTest {

  @Test
  public void calculate() {
    // Given
    BasicCalculator basicCalculator = new BasicCalculator();

    // When
    int calculate = basicCalculator.calculate(" 2-1 + 2 ");

    // Then
    assertThat(calculate, is(23));
  }
}