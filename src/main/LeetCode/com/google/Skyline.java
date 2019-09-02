package com.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created by ychang on 1/2/2017.
 */
public class Skyline {
  /**
   * this method can beat 70%, Time: O(N*lgN) for sort, Space: O(N)
   */
  public List<int[]> getSkyline(int[][] buildings) {
    /** process buildings, present each building as left-top vertices and right-top vertices, such as (x, y, left/right),
     * or (x, -y/+y) where y means left, -y means right ArrayList is faster than LinkedList
     */
    List<int[]> res = new ArrayList();
    List<int[]> points = new ArrayList();
    for (int[] b : buildings) {
      // each building is represented by a triplet of integers [Li, Ri, Hi]
      points.add(new int[]{b[0], b[2]}); // left edge
      points.add(new int[]{b[1], -b[2]}); // right edge
    }

    /**
     * Sort all vertices by x, when 2 building's connect (b1's right vertices == b2's left vertices), should compare y,
     * and must use descending order, because that can guarantee left vertices before right vertices to push to tree map,
     * so keep skyline continuous
     */
    Collections.sort(points, (o1, o2) -> o1[0]==o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]); // make sure start before end

    /**
     * Create a heap based on y, the head of the heap is the highest level of current heap, the key is the height, the
     * value is count_bruteForce of buildings currently "alive"
     */
    TreeMap<Integer, Integer> heights = new TreeMap<>(Comparator.reverseOrder());

    /**
     * we must first put 0 as default horizontal level, that is useful when skyline is not continuous and we need mark
     * the right-most vertices to end current skyline, and this point will never been removed from heap
     */
    heights.put(0, 1);
    int prev = 0;
    for (int[] p : points) {
      if (p[1]>0) { // left point
        heights.put(p[1], heights.getOrDefault(p[1], 0) + 1);
      } else { // right point, notice p[1] is neg number
        heights.put(-p[1], heights.get(-p[1]) - 1);
        if (heights.get(-p[1])==0)
          heights.remove(-p[1]);
      }

      // if after add/remove new vertices, the new pq's head (current highest height) changed, no matter higher or lower
      if (heights.firstKey()!=prev) {
        prev = heights.firstKey();
        res.add(new int[]{p[0], prev});
      }
    }
    return res;
  }

  /**
   * this method can beat 33%, this is because we use PriorityQueue instead of TreeMap to store height, PriorityQueue is
   * slower than TreeMap, because TreeMap is a totally sorted data structure, while PQ need change root each time root is pop
   */
  public List<int[]> getSkyline_priorityQueue(int[][] buildings) {
    List<int[]> res = new ArrayList();
    List<int[]> points = new LinkedList();
    for (int[] b : buildings) {
      points.add(new int[]{b[0], b[2]});
      points.add(new int[]{b[1], -b[2]});
    }
    /**
     * when 2 buildings start-end-connected, make sure next-building's start before prev-building's end, so can erase duplicated points
     * such as [1, 3, 2], [3, 4, 2] should be [1, 2] [4, 0], not [1, 2] [3, 0], [3, 2], [4, 0]
     */
    Collections.sort(points, (o1, o2) -> o1[0]==o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]); // make sure start before end
    PriorityQueue<Integer> heights = new PriorityQueue<>(Comparator.reverseOrder());
    heights.offer(0);
    int prev = 0;
    for (int[] p : points) {
      if (p[1]>0)
        heights.offer(p[1]);
      else
        heights.remove(-p[1]);
      int cur = heights.peek(); // current highest height
      if (cur!=prev) {
        res.add(new int[]{p[0], cur});
        prev = cur;
      }
    }
    return res;
  }

  /**
   * this method can beat 16%, this is because we use PriorityQueue to sort points instead of first inserting to a list,
   * finally sort the whole list.
   */
  public List<int[]> getSkyline_doublePriorityQueue(int[][] buildings) {
    List<int[]> res = new ArrayList();

    /**
     * when 2 buildings start-end-connected, make sure next-building's start before prev-building's end, so can erase
     * duplicated points such as [1, 3, 2], [3, 4, 2] should be [1, 2] [4, 0], not [1, 2] [3, 0], [3, 2], [4, 0]
     * Please notice after insert all points into PriorityQueue, if check points, we can find PriorityQueue is NOT all
     * sorted, that is because this data structure is "A binary heap" which means it is only partially ordered, with
     * the smallest element at the root. When you remove that, the heap is reordered so that the next smallest element
     * is at the root.
     */
    PriorityQueue<int[]> points = new PriorityQueue<>((o1, o2) -> o1[0]==o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
    for (int[] b : buildings) {
      points.add(new int[]{b[0], b[2]});
      points.add(new int[]{b[1], -b[2]});
    }
    PriorityQueue<Integer> heights = new PriorityQueue<>(Comparator.reverseOrder());
    heights.offer(0);
    int prev = 0, size = points.size();

    /**
     * since PriorityQueue is partially sorted, we could not iterate it to get a sorted list, but we can use remove() to
     * get the top node each time to get a sorted list. MUST first set points.size() to a var, instead of using
     * i<points.size(), because points.size() changes during we remove element from it.
     */
    for (int i = 0; i<size; i++) {
      int[] p = points.remove();
      if (p[1]>0)
        heights.offer(p[1]);
      else
        heights.remove(-p[1]);
      int cur = heights.peek(); // current highest height
      if (cur!=prev) {
        res.add(new int[]{p[0], cur});
        prev = cur;
      }
    }
    return res;
  }
}