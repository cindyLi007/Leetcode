package com.google.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoomerangTest {

    @Test
    public void isBoomerang() {
        // Given
        Boomerang boomerang = new Boomerang();

        // When
        boomerang.isBoomerang(new int[][]{{0, 1}, {1, 1}, {2, 1}});
    }
}