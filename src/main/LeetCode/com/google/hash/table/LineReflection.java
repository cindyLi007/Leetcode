package com.google.hash.table;

import java.util.HashSet;
import java.util.Set;

public class LineReflection {

    public boolean isReflected(int[][] points) {
        Set<String> set = new HashSet();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int[] p : points) {
            max = Math.max(max, p[0]);
            min = Math.min(min, p[0]);
            set.add(p[0] + "#" + p[1]);
        }
        // use max and min to find the constant sum, for each points, must have p[0]+p'[0]==sum && p[1]==p'[1] to
        // satifies the reflection line
        int sum = max + min;
        for (int[] p : points) {
            if (!set.contains((sum-p[0]) + "#" + p[1])) return false;
        }
        return true;
    }
}
