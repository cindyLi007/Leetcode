package com.google.dp;

import org.junit.Test;
import org.mockito.BDDMockito;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MajorityElementIITest {

    @Test
    public void majorityElement_II() {
        // Given
        MajorityElementII majorityElementII = new MajorityElementII();

        // When
        List<Integer> majorityElement = majorityElementII.majorityElement(new int[]{3, 2, 3});

        // Then
        majorityElement.stream().forEach(System.out ::print);
    }

    @Test
    public void majorityElement() {
        // Given
        MajorityElement majorityElement = new MajorityElement();

        // When
        int res = majorityElement.majorityElement(new int[]{3, 2, 3});

        // Then
        assertThat(res, is(3));
    }
}