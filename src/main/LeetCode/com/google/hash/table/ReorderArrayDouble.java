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
    public static boolean canReorderDoubled(int[] A) {
        // return a map which is orderded by key's value (num in A)
        // <num, frequency> map, O(N*lgK)
        Map<Integer, Integer> map = new TreeMap<>();
        for (int n : A) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        // return a key iterator in ascending order
        for (int key : map.keySet()) {
            if (map.get(key)==0) continue;
            // if key < 0, in the ordered TreeMap, we have not encounter the samller one, so we need /2.
            // for ex. -4, -2, -1, when handle -4, we need find -2, when handle -2, we need find -1.
            if (key<0 && key%2!=0) return false;
            int want = key<0 ? key/2 : key*2;
            map.put(want, map.getOrDefault(want, 0) - map.get(key));
            if (map.get(want)<0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String... args) {
        boolean res = canReorderDoubled(new int[]{-5, -2, 2, 4});
        System.out.println(res);
    }
}
