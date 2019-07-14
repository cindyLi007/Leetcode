package com.google.hash.table;

import java.util.*;

import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;

/**
 * Created by ychang on 2/9/2017.
 */
public class TopKFrequentElement {
  public List<Integer> topKFrequent_Multimap(int[] nums, int k) {
    /**
     * map is num -> times pair
    */
    Map<Integer, Integer> map = new HashMap();
    for (int num : nums) {
      if (!map.containsKey(num)) map.put(num, 0);
      map.put(num, map.get(num)+1);
    }
    /**
     * TreeMultimap need 2 comparators, one for key, one for value
     */
    Multimap<Integer, Integer> tree = TreeMultimap.create((a1, a2) -> a2-a1, (a1, a2) -> a1-a2);
    for (Integer key : map.keySet()) {
      tree.put(map.get(key), key);
    }
    List<Integer> res = new LinkedList();
    int i=k;
    for (Integer key : tree.keySet()) {
      Collection<Integer> list = tree.get(key);
      res.addAll(list);
      i-=list.size();
      if (i<=0) break;
    }
    return res;
  }

  /**
   * beat 47%
   */
  public List<Integer> topKFrequent_TreeMap_Stream(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0)+1);
    }
    PriorityQueue<Integer> pq = new PriorityQueue(k, (o1, o2) -> map.get(o1) - map.get(o2));
    for (Integer key : map.keySet()) {
      pq.offer(key);
      if (pq.size()>k) pq.poll();
    }
    /*
    System.out.println(pq.peek());
    map.put(3, 4);
    pq.remove(3);
    pq.add(3);
    System.out.println(pq.peek());
    this part is to test when the value of an itme in heap change, whether it will be re-ordered automatically
    */

    List<Integer> res = new ArrayList();
    while (!pq.isEmpty()) {
      res.add(pq.poll());
    }
    Collections.reverse(res);
    return res;
  }

}
