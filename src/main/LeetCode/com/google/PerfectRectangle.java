package com.google;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ychang on 12/19/2016.
 * The right answer must satisfy two conditions:
     1) the large rectangle area should be equal to the sum of small rectangles
     2) count_bruteForce of all the points should be even(0, or %2==0), that means all rectangles can adjacent each other
        and count_bruteForce of all the four corner points must be one
 */
public class PerfectRectangle {
  public boolean isRectangleCover(int[][] rectangles) {
    int x1=Integer.MAX_VALUE, y1=x1;
    int x2=0, y2=0;
    int area=0;
    Set<String> set = new HashSet();

    for (int[] rec : rectangles) {
      x1=Math.min(x1, rec[0]);
      y1=Math.min(y1, rec[1]);
      x2=Math.max(x2, rec[2]);
      y2=Math.max(y2, rec[3]);

      area+=(rec[2]-rec[0])*(rec[3]-rec[1]);

      String p1 = rec[0]+" "+rec[1];
      String p2 = rec[0]+" "+rec[3];
      String p3 = rec[2]+" "+rec[1];
      String p4 = rec[2]+" "+rec[3];

      if (!set.add(p1)) set.remove(p1);
      if (!set.add(p2)) set.remove(p2);
      if (!set.add(p3)) set.remove(p3);
      if (!set.add(p4)) set.remove(p4);
    }

    if (!set.contains(x1+" "+y1) || !set.contains(x1+" "+y2) || !set.contains(x2+" "+y1) || !set.contains(x2+" "+y2) || set.size()!=4)
      return false;

    return area == (x2-x1)* (y2-y1);
  }

  public static void main(String[] args) {
//    int[][] array = new int[][]{{1,1,3,3}, {3,1,4,2}, {3,2,4,4}, {1,3,2,4}, {2,3,3,4}};
//    int[][] array = new int[][]{{1,1,2,3}, {1,3,2,4}, {3,1,4,2}, {3,2,4,4}};
//    int[][] array = new int[][]{{1,1,3,3}, {3,1,4,2}, {1,3,2,4}, {3,2,4,4}};
//    int[][] array = new int[][]{{1,1,3,3}, {3,1,4,2}, {1,3,2,4}, {2,2,4,4}};
    int[][] array = new int[][]{{1,1,3,3}, {3,3,4,2}, {1,3,2,4}, {2,2,4,4}};
    PerfectRectangle pr = new PerfectRectangle();
    System.out.println(pr.isRectangleCover(array));
  }
}
