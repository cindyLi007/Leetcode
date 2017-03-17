package com.google.hash.table;

import static java.lang.Integer.MAX_VALUE;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ychang on 2/16/2017.
 */
public class MaxPointsOnALine {
  /**
   * this one could not pass a test case when double precision limitation is overflowed
   * For example, [[0,0],[94911151,94911150],[94911152,94911151]], the points [94911151,94911150],[94911152,94911151] to [0, 0]
   * have a very slightly diff in slope, but use division could not tell that which make the 2 slopes to [0,0] are same.
   * So in this method it returned 3.
   */
  public int maxPoints_overFlow(Point[] points) {
    // base case
    if (points.length<=2)
      return points.length;

    int result = 0;
    Map<Double, Integer> map = new HashMap();
    for (int i = 0; i<points.length-1; i++) {
      map.clear();
      int dup = 0;
      /** we must have this to make map at least have one entry, otherwise if all points ara same, map is empty so could not
       * go into the loop to go through map values. This entry is for a point which has same x with points[i]
       */
      map.put((double)Integer.MAX_VALUE, 1);
      for (int j = i+1; j<points.length; j++) {
        if ((points[j].x==points[i].x) && (points[j].y==points[i].y)) {
          dup++;
          continue;
        }

        /** if the line through 2 points are parallel to y, we could not use slope formula, in that case, we set max int as the key
        */
        double k = points[i].x==points[j].x ? MAX_VALUE :
            /**
             * In Java 0.0 != -0.0, when 2 points are parallel to x, we maybe get 2 slope, 0.0. or -0.0, which will be fall into 2 keys
             * for example, 0.0/-1.0=-0.0, 0.0/1.0=0.0. To resolve this problem, we use 0.0 + (-0.0) = 0.0
             */
            0.0 + (double) (points[j].y - points[i].y)/(double) (points[j].x - points[i].x);
        if (map.containsKey(k)) {
          map.put(k, map.get(k) + 1);
        } else {
          map.put(k, 2);
        }
      }

      for (int temp : map.values()) {
        result = Math.max(result, temp + dup);
      }
    }
    return result;
  }

  /**
   * To resolve maxPoints_overFlow problem, we need save (y2-y1), (x2-x1) pair as a key in the map. Instead of build a
   * map <Slope(double), number(integer)>, we build a map <Pair<Integer, Integer>, number>, where pair is (y2-y1), (x2-x1)
   * if dy=y2-y1, dx=x2-x1, we need make sure pair (8, 4), (4, 2), (2, 1) can be saved in same bucket. Because each of them
   * has same slope. so we need simplify all of them to (2,1). The easiest way is to make dy and dx divided by gcd(dy, dx).
   */
  public int maxPoints(Point[] points) {
    int res=0;
    Map<Map<Integer, Integer>, Integer> map = new HashMap();
    for (int i=0; i<points.length; i++) {
      map.clear();
      int dup=1;
      for (int j=i+1; j<points.length; j++) {
        if (points[i].x==points[j].x && points[i].y==points[j].y) {
          dup++; continue;
        }
        /**
         * dx and dy can NOT be both 0, so not matter that two points are parallel x or parallel y, gcd(0, v) returns v.
         * 0/v returns 0, v/v return 1, so all keys for points in line paralleled x/y are either <0, 1> or <1, 0>.
         */
        int dx = points[i].x-points[j].x, dy = points[i].y-points[j].y;
        int gcd = gcd(dx, dy);
        Map<Integer, Integer> m = new HashMap();
        m.put(dx/gcd, dy/gcd);
        map.put(m, map.getOrDefault(m, 0)+1);
      }
      res=Math.max(res, dup);
      for (Integer k : map.values()) {
        res=Math.max(res, k+dup);
      }
    }
    return res;
  }

  private int gcd(int a, int b) {
    return b==0 ? a : gcd(b, a%b);
  }

}
