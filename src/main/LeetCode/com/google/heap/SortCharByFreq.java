package com.google.heap;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 * Input: "tree"
 * Output: "eert"
 */
public class SortCharByFreq {
    // Time: O(N*lgN), Space: O(N)
    public String frequencySort(String s) {
        Map<Character, Integer> map =new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Item> list = map.entrySet().stream().
                map(o -> new Item(o.getKey(), o.getValue())).collect(Collectors.toList());
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (Item item : list) {
            for (int i= 0; i<item.freq; i++) {
                sb.append(item.val);
            }
        }
        return sb.toString();
    }

    class Item implements Comparable<Item> {
        char val;
        int freq;

        Item(char c, int f) {
            val = c;
            freq = f;
        }
        @Override
        public int compareTo(Item o) {
            return o.freq - freq;
        }
    }
}
