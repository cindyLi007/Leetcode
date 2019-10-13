package com.google.math;

import java.util.HashSet;
import java.util.Set;

public class PerfectRectangle {
  public static boolean isRectangleCover(int[][] rectangles) {
    int area = 0;
    int x2=Integer.MIN_VALUE, x1=Integer.MAX_VALUE, y2=Integer.MIN_VALUE, y1=Integer.MAX_VALUE;
    Set<String> set = new HashSet();
    for (int[] rect : rectangles) {
      x1 = Math.min(x1, rect[0]);
      y1 = Math.min(y1, rect[1]);
      x2 = Math.max(x2, rect[2]);
      y2 = Math.max(y2, rect[3]);
      area += (rect[2]-rect[0]) * (rect[3]-rect[1]);
      if (!set.add(rect[0] + "-" + rect[1])) set.remove(rect[0] + "-" + rect[1]);
      if (!set.add(rect[0] + "-" + rect[3])) set.remove(rect[0] + "-" + rect[3]);
      if (!set.add(rect[2] + "-" + rect[1])) set.remove(rect[2] + "-" + rect[1]);
      if (!set.add(rect[2] + "-" + rect[3])) set.remove(rect[2] + "-" + rect[3]);
    }
    if (!set.contains(x1 + "-" + y1) || !set.contains(x1 + "-" + y2) ||
        !set.contains(x2 + "-" + y1) || !set.contains(x2 + "-" + y2) ||
        set.size() != 4)
      return false;
    return (area == (x2-x1) * (y2-y1)) && set.size()==4;
  }

  public static void main(String... args) {
    int[][] rectangles = new int[][]{
        {1,1,3,3},
        {3,1,4,2},
        {3,2,4,4},
        {1,3,2,4},
        {2,3,3,4}
    };
    System.out.println(isRectangleCover(rectangles));
  }

}
