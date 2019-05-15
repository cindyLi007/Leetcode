package com.google.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 914. X of a Kind in a Deck of Cards
 * In a deck of cards, each card has an integer written on it.
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 */
public class XKindDeckCards {
    // Time: O(N), Space: O(N)
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length<2) return false;
        Map<Integer, Integer> numToCount = new HashMap<>();
        for (int i : deck) {
            numToCount.put(i, numToCount.getOrDefault(i, 0)+1);
        }
        int smallestCount = deck.length;
        for (Integer value : numToCount.values()) {
            if (value == 1) return false;
            smallestCount = Math.min(smallestCount, value);
        }
        // For any number, if it mod smallest == 1, that means we could not split cards in >=2 group
        for (Integer value : numToCount.values()) {
            if (value%smallestCount==1) return false;
        }
        return true;
    }
}
