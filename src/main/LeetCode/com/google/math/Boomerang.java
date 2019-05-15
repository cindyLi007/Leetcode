package com.google.math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Boomerang {
    public boolean isBoomerang(int[][] points) {
        // https://www.mathopenref.com/coordtrianglearea.html
        // https://medium.com/algorithm-and-datastructure/valid-boomerang-414f9df2b22c
        // We can compare area usig points[0]==points[1], it is same as follow
        // Arrays.equals(points[0], points[1]);

        int x0=points[0][0], y0=points[0][1];
        int x1=points[1][0], y1=points[1][1];
        int x2=points[2][0], y2=points[2][1];

        // in coord, triangle area is 0.5 * (Math.abs(x0*(y1-y2) + x1*(y2-y0) + x2*(y0-y1))), so if triangle area is 0,
        // the 3 points must be in one straight line
        return x0*(y1-y2) + x1*(y2-y0) + x2*(y0-y1) != 0;
    }
}
