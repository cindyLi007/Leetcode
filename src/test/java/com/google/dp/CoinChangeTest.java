package com.google.dp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CoinChangeTest {

    @Test
    public void coinChange() {
        // Given
        CoinChange coinChange = new CoinChange();

        // When
        int res = coinChange.coinChange(new int[]{1, 2, 5}, 11);

        // Then
        assertThat(res, is(3));
    }
}