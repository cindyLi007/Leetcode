package com.google.hash.table;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomPickWithBlacklistTest {

    @Test
    public void pick() {
        // Given
        RandomPickWithBlacklist randomPickWithBlacklist = new RandomPickWithBlacklist(3, new int[]{0});

        // When
        for (int i = 0; i < 23; i++) {
            System.out.println(randomPickWithBlacklist.pick());
        }
    }
}