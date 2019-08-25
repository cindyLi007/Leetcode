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
    public static boolean hasGroupsSizeX_Wrong(int[] deck) {
        if (deck.length<2) return false;
        Map<Integer, Integer> numToCount = new HashMap<>();
        for (int i : deck) {
            numToCount.put(i, numToCount.getOrDefault(i, 0)+1);
        }
        // the following code is wrong, because from the ex. input, smallestCount is 6, the other 2 values are 8 and 9
        // each of them % smallestCount > 1 but 8 and 9 gcd is 1 so for this input it should return false;
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

    // Time: O(N), Space: O(N)
    public static boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap();
        for (int i : deck) map.put(i, map.getOrDefault(i, 0) + 1);
        int res = 0;
        for (Integer v : map.values()) {
            res = gcd(res, v);
        }
        return res>1;
    }

    private static int gcd(int a, int b) {
        return a==0 ? b : gcd(b%a, a);
    }

    public static void main(String... args) {
        int[] deck = new int[]{0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2,2,1,1,1,1,1,1};
        boolean res = hasGroupsSizeX(deck);
        System.out.println(res);
    }
}
