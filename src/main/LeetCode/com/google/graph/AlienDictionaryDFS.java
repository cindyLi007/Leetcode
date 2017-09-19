package com.google.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ychang on 6/6/2017.
 * this can beat 83%
 */
public class AlienDictionaryDFS {

  public String alienOrder(String[] words) {
    /**
     * an array for 26 char. -1 means not existing, 0 means not visited, 1 means in stack, 2 means done
     */
    int[] visited = new int[26];
    Arrays.fill(visited, -1);
    Map<Integer, Set<Integer>> map = buildGraph(words, visited); // directed graph <nodes, set of pointing-to nodes>

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i<26; i++) {
      if (!dfs(visited, i, map, sb))
        return "";
    }
    return sb.toString();
  }

  private Map<Integer, Set<Integer>> buildGraph(String[] words, int[] visited) {
    // init visited to identify all char in all words, all visited[i]==0 means it is in words
    for (String word : words) {
      for (char c : word.toCharArray()) {
        visited[c - 'a'] = 0;
      }
    }
    Map<Integer, Set<Integer>> map = new HashMap();
    for (int i = 0; i<words.length - 1; i++) {
      String w1 = words[i], w2 = words[i + 1];
      int len = Math.min(w1.length(), w2.length());
      for (int j = 0; j<len; j++) {
        int c1 = w1.charAt(j) - 'a', c2 = w2.charAt(j) - 'a';
        if (c1!=c2) {
          // this is much faster than map.computeIfAbsent
          if (!map.containsKey(c1))
            map.put(c1, new HashSet());
          map.get(c1).add(c2);
          break;
        }
      }
    }
    return map;
  }

  private boolean dfs(int[] visited, int ch, Map<Integer, Set<Integer>> map, StringBuilder sb) {
    // -1 means not in words, 0 means not visited, 1 means in stack, 2 means done
    if (visited[ch]==1)
      return false;
    if (visited[ch]==-1 || visited[ch]==2)
      return true;
    // first set visited[ch] to 1 means in stack, so later if visit this char again, we know this is a loop
    visited[ch] = 1;
    if (map.containsKey(ch) && map.get(ch).size()>0) {
      for (Integer i : map.get(ch)) {
        if (!dfs(visited, i, map, sb))
          return false;
      }
    }
    // must insert char in the 1st position, because all its' pointing nodes have been added to the sb.
    sb.insert(0, (char) (ch + 'a'));
    visited[ch] = 2;
    return true;
  }
}
