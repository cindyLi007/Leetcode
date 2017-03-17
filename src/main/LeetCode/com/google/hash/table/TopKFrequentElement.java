package com.google.hash.table;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
  public List<Integer> topKFrequent_TreeMap(int[] nums, int k) {
    /**
     * map is num -> times pair
     */
    Map<Integer, Integer> map = new HashMap();
    for (int num : nums) {
      if (!map.containsKey(num)) map.put(num, 0);
      map.put(num, map.get(num)+1);
    }
    /**
     * can use natural order
     */
    TreeMap<Integer, List<Integer>> tree = new TreeMap();
    for (Integer key : map.keySet()) {
      if (!tree.containsKey(map.get(key))) tree.put(map.get(key), new LinkedList());
      tree.get(map.get(key)).add(key);
    }
    List<Integer> res = new LinkedList();
    for (int i=k; i>0; ) {
      /**
       * poll last one since it is the most frequent
       */
      List<Integer> list = tree.pollLastEntry().getValue();
      res.addAll(list);
      i-=list.size();
    }
    return res;
  }

}
