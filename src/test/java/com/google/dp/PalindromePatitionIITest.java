package com.google.dp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PalindromePatitionIITest {

    @Test
    public void minCut() {
        // Given
        PalindromePatitionII palindromePatitionII = new PalindromePatitionII();

        // When
        int res = palindromePatitionII.minCut("aab");

        // Then
        assertThat(res, is(1));
    }
}