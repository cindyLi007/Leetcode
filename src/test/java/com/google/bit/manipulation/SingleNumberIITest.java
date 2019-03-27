package com.google.bit.manipulation;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SingleNumberIITest {

    @Test
    public void singleNumber() {
        // Given
        SingleNumberII singleNumberII = new SingleNumberII();

        // When
        int res = singleNumberII.singleNumber(new int[]{2, 2, 3, 2});

        // Then
        assertThat(res, is(3));
    }
}