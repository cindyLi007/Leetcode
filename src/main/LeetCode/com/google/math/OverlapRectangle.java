package com.google.math;

/** 836. Rectangle Overlap
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner,
 * and (x2, y2) are the coordinates of its top-right corner.
 * Two rectangles overlap if the area of their intersection is positive.  To be clear, two rectangles that only touch
 * at the corner or edges do not overlap.
 * Given two (axis-aligned) rectangles, return whether they overlap.
 */
public class OverlapRectangle {
  // Time: O(1)
  public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    return !(rec1[2] <= rec2[0] // rec1 is in left of rec2
        || rec1[0] >= rec2[2] // rec1 is in right of rec2
        || rec1[1] >= rec2[3] // rec1 is in up of rec2
        || rec1[3] <= rec2[1]); // rec1 is in bottom of rec2
  }
}
