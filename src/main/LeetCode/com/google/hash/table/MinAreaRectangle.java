package com.google.hash.table;

import java.util.*;

/**
 * Leetcode 939
 * Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points, with sides
 * parallel to the x and y axes.
 *
 * If there isn't any rectangle, return 0.
 */
public class MinAreaRectangle {
    // Space: O(N) N is # of rows
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        // Build up a map, key is the X, value is a list of all Y in that X
        for (int[] point : points) {
            int x = point[0], y = point[1];
            map.computeIfAbsent(x, z->new HashSet<>()).add(y);
        }
        if (map.size()<=1) return 0;

        int res = Integer.MAX_VALUE;

        ArrayList<Integer> rows = new ArrayList<>(map.keySet());
        // O(N*lgN) n is # of rows
        Collections.sort(rows);
        // O(N*N)
        for (int i=0; i<rows.size(); i++) {
            Integer key = rows.get(i);
            // only one points in this row, could not form a line
            if (map.get(key).size()<=1) continue;
            for (int j=i+1; j< rows.size(); j++) {
                if (j-i >= res) break;
                if (map.get(rows.get(j)).size()<=1) continue;
                Set<Integer> cur = new HashSet<>(map.get(key));
                // cur only retains all intersection points of 2 rows
                cur.retainAll(map.get(rows.get(j)));
                if (cur.size()>=2) {
                    // we find the minDistance between 2 Ys
                    res = Math.min(res, (rows.get(j)-rows.get(i)) * minDist(cur));
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    // Time: O(M*lgM) M is the number of columns
    private int minDist(Set<Integer> cur) {
        List<Integer> list = new ArrayList<>(cur);
        Collections.sort(list);
        int min = list.get(list.size()-1) - list.get(0);
        for (int i=0; i<list.size()-1; i++) {
            min = Math.min(min, list.get(i+1) - list.get(i));
        }
        return min;
    }

    public static void main(String... args) {
        MinAreaRectangle minAreaRectangle = new MinAreaRectangle();
        System.out.println(minAreaRectangle.minAreaRect(new int[][]{{36219,4673},{26311,36047},{26311,4673},{36219,16024},{17010,16024},{26311,6287},{22367,6287},{17010,36047},{17010,6287},{22367,16024},{36219,6287},{22367,4673},{17010,4673},{36219,36047}}));
    }
}
