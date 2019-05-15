package com.google.heap;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MinCostHiringWorkersTest {

    @Test
    public void mincostToHireWorkers() {
        // Given
        int[] Q = new int[]{10, 20, 50};
        int[] W = new int[]{200, 50, 500};
        MinCostHiringWorkers minCostHiringWorkers = new MinCostHiringWorkers();

        // When
        double res = minCostHiringWorkers.mincostToHireWorkers(Q, W, 1);

        // Then
        assertThat(res, is(30.66667));
    }
}