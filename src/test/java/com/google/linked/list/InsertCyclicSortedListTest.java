package com.google.linked.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class InsertCyclicSortedListTest {

    @Test
    public void insert() {
        // Given
        InsertCyclicSortedList insertCyclicSortedList = new InsertCyclicSortedList();
        Node node_1 = new Node(1, null);
        Node node_3 = new Node(3, node_1);
        Node node_2 = new Node(2, node_3);
        node_1.next = node_2;

        // When
        Node node = insertCyclicSortedList.insert(node_1, 0);

        // Then
    }
}