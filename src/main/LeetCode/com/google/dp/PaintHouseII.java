package com.google.dp;

/**
 * Created by ychang on 5/31/2017.
 * There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with
 * a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 * The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0]
 * is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on...
 * Find the minimum cost to paint all houses.
 */
public class PaintHouseII {
  /**
   * We should cache previous row's the smallest and the 2nd smallest cost color indexes, when we go to current row to
   * calculate each color costs, we compare color index with prev 2 color indexes, and choose one. Also during calculate
   * current row, we need record the smallest and the 2nd smallest color index for next row use.
   */
  public int minCostII(int[][] costs) {
    if (costs.length==0 || costs[0].length==0) return 0;
    int houses=costs.length, color=costs[0].length;
    int i0=-1, i1=-1;
    for (int row=0; row<houses; row++) {
      int t0=-1, t1=-1;
      for (int i=0; i<color; i++) {
        /**
         * calculate each color min costs
         */
        if (row!=0) {
          int min = i==i0 ? i1 : i0;
          costs[row][i]+=costs[row-1][min];
        }
        /**
         * record current row the smallest and the 2nd smallest value's indexes
         */
        if (t0==-1 || costs[row][i]<costs[row][t0]) {
          t1=t0; t0=i;
        } else if (t1==-1 || costs[row][i]<costs[row][t1]) {
          t1=i;
        }
      }
      i0=t0; i1=t1;
    }
    return costs[houses-1][i0];
  }
}
