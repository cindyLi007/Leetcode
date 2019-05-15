package com.google.hash.table;

import java.util.Map;
import java.util.TreeMap;

/**
 * leetcode 954
 * Given an array of integers A with even length, return true if and only if it is possible to reorder it
 * such that A[2 * i + 1] = 2 * A[2 * i] for every 0 <= i < len(A) / 2.
 */
public class ReorderArrayDouble {
    // Time: O(N*lgK), K is the distict number in A, Space: O(N)
    public boolean canReorderDoubled(int[] A) {
        // return a map which is orderded by key's value (num in A)
        // <num, frequency> map
        Map<Integer, Integer> map = new TreeMap<>();
        for (int n : A) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        // return a key iterator in ascending order
        for (int key : map.keySet()) {
            if (map.get(key)==0) continue;
            int want = key < 0 ? key/2 : key * 2;
            if (key<0 && key%2!=0 || map.getOrDefault(want, 0) < map.get(key)) {
                return false;
            }
            map.put(want, map.get(want) - map.get(key));
        }
        return true;
    }
}
