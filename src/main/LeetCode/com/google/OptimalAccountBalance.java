package com.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.google.common.collect.Interner;
import com.google.common.collect.Maps;

/**
 * Created by ychang on 12/24/2016.
 * TreeMap can only sort by the key. A TreeMap is always sorted by the keys, anything else is impossible.
 */
public class OptimalAccountBalance {
  public int minTransfers(int[][] transactions) {
    if (transactions==null || transactions.length==0 || transactions[0].length==0)
      return 0;
    int res = 0;
    // build a map for every node
    Map<Integer, Integer> map = new HashMap();
    for (int[] trans : transactions) {
      int from = trans[0], to = trans[1], val = trans[2];
      if (!map.containsKey(from))
        map.put(from, 0);
      if (!map.containsKey(to))
        map.put(to, 0);
      map.put(from, map.get(from) - val);
      map.put(to, map.get(to) + val);
    }

    // remove all matched delta nodes
    List<Integer> list = map.values().stream().filter(v -> v!=0).collect(Collectors.toList());
    res += removeMatchedDelta(list);
    return res + minTransfers(list, 0);
  }

  private int minTransfers(List<Integer> list, int start) {
    // base case
    while (start<list.size() && list.get(start)==0)
      start++;
    if (start==list.size())
      return 0;

    int res = Integer.MAX_VALUE;
    int val = list.get(start);
    for (int i = start + 1; i<list.size(); i++) {
      if ((long) val*list.get(i)<0) {
        list.set(i, list.get(i) + val);
        res = Math.min(res, 1 + minTransfers(list, start + 1));
        list.set(i, list.get(i) - val);
      }
    }
    return res;
  }

  private int removeMatchedDelta(List<Integer> list) {
    Collections.sort(list);
    int i = 0, j = list.size() - 1, res = 0;
    while (i<j) {
      int sum = list.get(i) + list.get(j);
      if (sum==0) {
        list.remove(i);
        list.remove(j - 1);
        j -= 2;
        res++;
      } else if (sum<0) {
        i++;
      } else {
        j--;
      }
    }
    return res;
  }

}
