package com.google.string;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BinaryStringWithSubstringTest {

    @Test
    public void queryString() {
        // Given
        BinaryStringWithSubstring binaryStringWithSubstring = new BinaryStringWithSubstring();

        // When
        boolean result = binaryStringWithSubstring.queryString("0111001000", 9);

        // Then
        assertThat(result, is(false));
    }
}