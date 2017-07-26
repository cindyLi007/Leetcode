package com.google.stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 6/22/2017.
 */
public class TagValidationTest {
  @Test
  public void isValid() throws Exception {
    // Given
    TagValidation tagValidation = new TagValidation();
    String string = "<A><A>/A></A></A>";

    // When
    boolean isValid = tagValidation.isValid(string);

    // Then
    assertThat(isValid, is(true));
  }

}