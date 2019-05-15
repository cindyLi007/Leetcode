package com.google.heap;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SortCharByFreqTest {

    @Test
    public void frequencySort() {
        // Given
        SortCharByFreq sortCharByFreq = new SortCharByFreq();

        // When
        String newStr = sortCharByFreq.frequencySort("tree");

        // Then
        assertThat(newStr, is("eert | eetr"));
    }
}