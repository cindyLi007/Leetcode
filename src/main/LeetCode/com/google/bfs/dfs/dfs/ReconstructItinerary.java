package com.google.bfs.dfs.dfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by ychang on 2/27/2017.
 */
public class ReconstructItinerary {
  public List<String> findItinerary_recursive(String[][] tickets) {
    List<String> route = new LinkedList();
    Map<String, PriorityQueue<String>> map = new HashMap();
    // construct V - edges pair (start point -> destination points)
    for (String[] ticket : tickets) {
      /**
       * this computeIfAbsent is used when no key entry, add the value, if already has the key, will NOT replace the value
       * however for multi-value map, Map<K,Collection<V>>, will add duplicated value to the collection
       */
      map.computeIfAbsent(ticket[0], k->new PriorityQueue()).add(ticket[1]);
    }
    dfs("JFK", map, route);
    return route;
  }

  private void dfs(String start, Map<String, PriorityQueue<String>> map, List<String> res) {
    PriorityQueue<String> des = map.get(start);
    while (des!=null && !des.isEmpty()) {
      dfs(des.poll(), map, res);
    }
    /**
     * dfs like a stack, we should add bottom to the first, last visit is in the top of stack, should be visited early.
     */
    res.add(0, start);
  }

  public List<String> findItinerary(String[][] tickets) {
    Map<String, PriorityQueue<String>> map = new HashMap();
    List<String> route = new LinkedList();
    /**
     * build a map start - all destinations, sorted by lexical order
     */
    for (String[] ticket : tickets) {
      map.computeIfAbsent(ticket[0], k->new PriorityQueue()).add(ticket[1]);
    }
    Stack<String> stack = new Stack();
    stack.push("JFK");
    while(!stack.empty()) {
      String start = stack.pop();
      PriorityQueue<String> des = map.get(start);
      while (des!=null && !des.isEmpty()) {
        stack.push(start);
        start=des.poll();
        des=map.get(start);
      }
      route.add(0, start);
    }
    return route;
  }
}
