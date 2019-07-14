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
       * this computeIfAbsent is used when no key entry, add the PriorityQueue, if already has the key, will NOT replace the PriorityQueue
       * however for multi-value map, Map<K,Collection<V>>, will add duplicated value to the collection
       */
      map.computeIfAbsent(ticket[0], k->new PriorityQueue()).offer(ticket[1]);
    }
    dfs("JFK", map, route);
    return route;
  }

  private void dfs(String startAirport, Map<String, PriorityQueue<String>> graph, List<String> res) {
    // graph does not contain the startAirport means this airport has no outgoing flight, it is the final destination
    // graph contains the startAirport but the PriorityQueue is empty means we have visited all its outgoing flight
    while (graph.containsKey(startAirport) && !graph.get(startAirport).isEmpty()) {
      dfs(graph.get(startAirport).poll(), graph, res);
    }
    /**
     * dfs like a stack, we should add bottom to the first, last visit is in the top of stack, should be visited early.
     */
    res.add(0, startAirport);
  }

  public List<String> findItinerary(String[][] tickets) {
    Map<String, PriorityQueue<String>> graph = new HashMap();
    List<String> route = new LinkedList();
    /**
     * build a map start - all destinations, sorted by lexical order
     */
    for (String[] ticket : tickets) {
      graph.computeIfAbsent(ticket[0], k->new PriorityQueue()).offer(ticket[1]);
    }
    Stack<String> stack = new Stack();
    stack.push("JFK");
    while (!stack.isEmpty()) {
      String start = stack.pop();
      while (graph.containsKey(start) && !graph.get(start).isEmpty()) {
        stack.push(start);
        start = graph.get(start).poll();
      }
      route.add(0, start);
    }
    return route;
  }
}
