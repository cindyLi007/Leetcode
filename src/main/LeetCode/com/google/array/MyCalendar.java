package com.google.array;

import java.util.TreeMap;

public class MyCalendar {
    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        // The floorKey(K key) method is used to return the greatest key less than or equal to the given key, or null if there is no such key.
        Integer prev = map.floorKey(start);
        // The ceilingKey(K key) method is used to return the least key greater than or equal to the given key, or null if there is no such key.
        Integer next = map.ceilingKey(start);
        if ((prev==null || map.get(prev) <=start) && (next==null || end <= next)) {
            map.put(start, end);
        } else {
            return false;
        }
        return true;
    }
}
