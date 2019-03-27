package com.google.stack;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ValidIpAddressTest {

    @Test
    public void validIPAddress() {
        // Given
        ValidIpAddress validIpAddress = new ValidIpAddress();
        
        // When
        String s = validIpAddress.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:");

        // Then
        assertThat(s, is("Neither"));
    }
}