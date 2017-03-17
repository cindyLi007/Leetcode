package com.google;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

import com.google.common.collect.Lists;

/**
 * Created by ychang on 1/2/2017.
 */
public class Skyline {
  public List<int[]> getSkyline(int[][] buildings) {
    /** process buildings, present each building as left-top vertices and right-top vertices
      such as (x, y, left/right), or (x, -y/+y) where -y means left, +y means right
     */
    List<int[]> bList = Lists.newArrayList();
    for (int[] building : buildings) {
      bList.add(new int[]{building[0], -building[2]});
      bList.add(new int[]{building[1], building[2]});
    }

    /**
     * Sort all vertices by x, when 2 building's connect (b1's right vertices == b2's left vertices), should compare y,
     * and must use ascending order, because that can guarantee left vertices before right vertices to push to tree map,
     * (left vertices are negative), so keep skyline continuous
     */
    Collections.sort(bList, (o1, o2) -> o1[0]==o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

    /**
     * Create a heap based on y, the head of the heap is the highest level of current heap
     */
    TreeMap<Integer, Integer> pq = new TreeMap<>(Comparator.reverseOrder());
    /**
     * we must first put 0 as default horizontal level, that is useful when skyline is not continuous and we need mark
     * the right-most vertices to end current skyline, and this point will never been removed from pq
     */
    pq.put(0, 1);

    List<int[]> res = Lists.newArrayList();
    int prev = 0; //prev contains previous highest height
    for (int[] vertices : bList) {
      if (vertices[1]<0) { // left-top point of a building
        pq.put(-vertices[1], pq.getOrDefault(-vertices[1], 0)+1);
      } else { // right-top point of a building, so we need pop up the corresponding left-top point of the building
        pq.put(vertices[1], pq.get(vertices[1])-1);
        if (pq.get(vertices[1])==0) {
          pq.remove(vertices[1]);
        }
      }

      // if after add/remove new vertices, the new pq's head (current highest height) changed, no matter higher or lower
      int cur = pq.firstKey();
      if (cur!=prev) {
        res.add(new int[]{vertices[0], cur});
        prev=cur;
      }
    }
    return res;
  }
}
