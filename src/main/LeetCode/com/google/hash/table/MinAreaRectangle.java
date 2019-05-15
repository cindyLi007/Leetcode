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
    public int minAreaRect(int[][] points) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        // Build up a map, key is the X, value is a list of all Y in that X
        for (int[] point : points) {
            int x = point[0], y = point[1];
            map.computeIfAbsent(x, z->new ArrayList()).add(y);
        }
        int res = Integer.MAX_VALUE;
        // Build up a map, key is hashcode of 2 Ys in the row, value is the corresponding X value
        Map<Integer, Integer> lastX = new HashMap<>();
        for (Integer row : map.keySet()) {
            if (map.get(row).size()<=1) continue;
            List<Integer> columns = map.get(row);
            Collections.sort(columns);
            for (int i=0; i<columns.size()-1; i++) {
                for (int j=i+1; j<columns.size(); j++) {
                    // i and j are 2 points in X row, their distance is y2-y1
                    int y1 = columns.get(i), y2 = columns.get(j);
                    int code =  y1* 40001 + y2;
                    if (lastX.containsKey(code)) {
                        res = Math.min(res, (row - lastX.get(code)) * (y2-y1));
                    }
                    // we always put new row in map, because we sort rows from lower to higher, so if later same pair of
                    // (y1, y2) must be closer to current row, not closer to previous (y1, y2) pair's row.
                    lastX.put(code, row);
                }
            }

        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
