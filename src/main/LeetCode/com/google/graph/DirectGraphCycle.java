package com.google.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 国人大哥放水
 找出一个direct graph里面的circle (假设只有一个）
 follow up: print那个circle
 */
public class DirectGraphCycle {

  public static List<Integer> findCycle(Map<Integer, List<Integer>> G) {
    Set<Integer> visited = new HashSet<>();
    List<Integer> res = new ArrayList<>();
    for (Integer vertex : G.keySet()) {
      dfs(vertex, G, visited, res, new HashSet<>());
      if (res.size() > 0) return res;
    }
    return Collections.emptyList();
  }

  private static boolean dfs(Integer vertex, Map<Integer, List<Integer>> G, Set<Integer> visited, List<Integer> res, HashSet<Object> curSet) {
    if (visited.contains(vertex)) return true;
    if (curSet.contains(vertex)) {
      res.add(vertex);
      return false;
    }
    curSet.add(vertex);
    for (Integer next : G.get(vertex)) {
      if (!dfs(next, G, visited, res, curSet)) {
        boolean r = false;
        if (res.contains(vertex)) r=true;
        res.add(0, vertex);
        return r;
      } else if (res.size() != 0) return true;
    }
    visited.add(vertex);
    return true;
  }

  public static void main(String... args) {
    Map<Integer, List<Integer>> G = new HashMap<Integer, List<Integer>>() {
      {
        put(0, Arrays.asList(1));
        put(1, Arrays.asList(2, 4));
        put(2, Arrays.asList(3));
        put(3, Arrays.asList(4));
        put(4, Arrays.asList(2));
      }
    };
    List<Integer> cycle = findCycle(G);
    cycle.stream().forEach(o -> System.out.print(o + "->"));
  }
}
