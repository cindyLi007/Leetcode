package com.google.bfs.dfs.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Leetcode 737
public class SentenceSimilarityII {

  // Time: O(N*P), Space: O(P), worst case for each search in N, it can search the whole Graph
  public boolean areSentencesSimilarTwo_dfs(String[] words1, String[] words2, List<List<String>> pairs) {
    if (words1.length != words2.length) return false;
    Map<String, Set<String>> G = new HashMap();
    // O(P)
    for (List<String> p : pairs) {
      String s1 = p.get(0), s2 = p.get(1);
      G.computeIfAbsent(s1, o -> new HashSet()).add(s2);
      G.computeIfAbsent(s2, o -> new HashSet()).add(s1);
    }
    // O(N*P)
    for (int i = 0; i < words1.length; i++) {
      if (!dfs(words1[i], words2[i], new HashSet(), G)) return false;
    }
    return true;
  }

  private boolean dfs(String s1, String s2, Set<String> visited,
                      Map<String, Set<String>> G) {
    if (s1.equals(s2)) return true;
    if (visited.contains(s1) || !G.containsKey(s1)) return false;
    visited.add(s1);
    for (String next : G.get(s1)) {
      if (dfs(next, s2, visited, G)) return true;
    }
    return false;
  }

  // Time: O(P + N*LgP), Space: O(P) 注意UnionFind的时间复杂度
  /** 用UnionFind的关键是如何表达每个String的ID，由于UnionFind用int index来存储ID，我们需要建立一个Sting 到 ID的map,
   * 也就是说每一个String有一个unique ID, but this ID's ancestor stored in UnionFind id[] array
   */
  public boolean areSentencesSimilarTwo_UnionFind(String[] words1, String[] words2, List<List<String>> pairs) {
    if (words1.length != words2.length) return false;
    Map<String, Integer> index = new HashMap();
    int count=pairs.size() * 2;
    UF uf = new UF(count);
    int idx = 0;
    for (List<String> p : pairs) {
      String s1 = p.get(0), s2 = p.get(1);
      if (!index.containsKey(s1)) index.put(s1, idx++);
      if (!index.containsKey(s2)) index.put(s2, idx++);
      uf.union(index.get(s1), index.get(s2));
    }
    for (int i=0; i<words1.length; i++) {
      String s1 = words1[i], s2 = words2[i];
      if (s1.equals(s2)) continue;
      if (!index.containsKey(s1) || !index.containsKey(s2) ||
          uf.find(index.get(s1)) != uf.find(index.get(s2))) return false;
    }
    return true;
  }

  class UF {
    int[] id;

    UF(int count) {
      id = new int[count];
      for (int i=0; i<count; i++) id[i]=i;
    }

    void union(int p, int q) {
      int x = find(p), y = find(q);
      if (x!=y) id[x]=y;
    }

    int find(int x) {
      while (x != id[x]) {
        id[x] = id[id[x]];
        x = id[x];
      }
      return x;
    }
  }
}
