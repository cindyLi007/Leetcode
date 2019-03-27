package com.google.binary.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FindKCloesestElementsTest {

    @Test
    public void findClosestElements() {
        // Given
        FindKCloesestElements findKCloesestElements = new FindKCloesestElements();
        int[] array = new int[] {0,0,1,2,3,3,4,7,7,8};

        // When
        List<Integer> closestElements = findKCloesestElements.findClosestElements(array, 3, 5);

        // Then
        assertThat(closestElements, contains(3, 3, 4));
    }
}