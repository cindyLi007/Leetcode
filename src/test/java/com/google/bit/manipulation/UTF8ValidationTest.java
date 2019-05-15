package com.google.bit.manipulation;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UTF8ValidationTest {

    @Test
    public void validUtf8_bitManipulation() {
        // Given
            UTF8Validation utf8Validation = new UTF8Validation();

        // When
        boolean result = utf8Validation.validUtf8_bitManipulation(new int[]{197, 130, 1});

        // Then
        assertThat(result, is(true));
    }
}