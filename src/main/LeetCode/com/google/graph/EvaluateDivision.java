package com.google.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://medium.com/@alexgolec/google-interview-problems-ratio-finder-d7aa8bf201e3
public class EvaluateDivision {
  // Time: O(N*(V+E)
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    // build a di-D graph
    Map<String, List<Edge>> G = buildGraph(equations, values);

    // from that graph, build queires one by one
    int N = queries.size(), i=0;
    double[] res = new double[N];
    for (List<String> q : queries) {
      res[i++] = dfs(q.get(0), q.get(1), G, 1.0, new HashSet());
    }
    return res;
  }

  // Time: O(V+E)
  private double bfs(String src, String dest, Map<String, List<Edge>> G) {
    if (!G.containsKey(src)) return -1.0;
    Deque<Edge> queue = new ArrayDeque();
    queue.offer(new Edge(src, 1.0));
    Set<String> visited = new HashSet();
    visited.add(src);

    while (!queue.isEmpty()) {
      Edge cur = queue.poll();
      if (cur.target.equals(dest)) return cur.val;
      if (G.containsKey(cur.target)) {
        for (Edge ed : G.get(cur.target)) {
          if (!visited.contains(ed.target)) {
            visited.add(ed.target);
            queue.offer(new Edge(ed.target, ed.val * cur.val));
          }
        }
      }
    }
    return -1.0;
  }

  private double dfs(String src, String dest, Map<String, List<Edge>> G, double v, Set<String> visited) {
    if (visited.contains(src)) return -1.0;
    visited.add(src);
    if (G.containsKey(src)) {
      if (src.equals(dest)) return v;
      for (Edge edge : G.get(src)) {
        double res = dfs(edge.target, dest, G, v*edge.val, visited);
        if (res!=-1) return res;
      }
    }
    visited.remove(src);
    return -1.0;
  }

  private Map<String, List<Edge>> buildGraph(List<List<String>> equations, double[] values) {
    int N = values.length;
    Map<String, List<Edge>> G = new HashMap();
    for (int i=0; i<N; i++) {
      List<String> e = equations.get(i);
      double v = values[i];
      String v1 = e.get(0), v2 = e.get(1);
      G.computeIfAbsent(v1, o -> new ArrayList()).add(new Edge(v2, v));
      G.computeIfAbsent(v2, o -> new ArrayList()).add(new Edge(v1, 1.0/v));
    }
    return G;
  }

  class Edge {
    String target;
    double val;

    Edge(String t, double v) {
      target = t;
      val = v;
    }
  }

  public static void main(String... args) {
    EvaluateDivision evaluateDivision = new EvaluateDivision();
    List<List<String>> equations = new ArrayList<>();
    equations.add(Arrays.asList("x1", "x2"));
    equations.add(Arrays.asList("x2", "x3"));
    equations.add(Arrays.asList("x1", "x4"));
    equations.add(Arrays.asList("x2", "x5"));
    double[] values = new double[]{3.0, 0.5, 3.4, 5.6};
    List<List<String>> queries = new ArrayList<>();
    queries.add(Arrays.asList("x2", "x4")); // 1.13333
    queries.add(Arrays.asList("x3", "x4")); // 2.26667
    queries.add(Arrays.asList("x4", "x3")); // 0.44118
    double[] res = evaluateDivision.calcEquation(equations, values, queries);
    Arrays.stream(res).forEach(o -> System.out.println(o));
  }
}
