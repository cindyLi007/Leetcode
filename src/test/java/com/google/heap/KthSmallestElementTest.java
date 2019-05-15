package com.google.heap;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class KthSmallestElementTest {

    @Test
    public void kthSmallest() {
        // Given
        KthSmallestElement kthSmallestElement = new KthSmallestElement();
        int[][] matrix = new int[][]{{1,5,9},{10,11,13},{12,13,15}};

        // When
        int kthSmallest = kthSmallestElement.kthSmallest(matrix, 8);

        // Then
        assertThat(kthSmallest, is(13));
    }
}