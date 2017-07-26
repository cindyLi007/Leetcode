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
    int[] visited=new int[26];
    Arrays.fill(visited, -1);
    Map<Integer, Set<Integer>> map = new HashMap(); // directed graph <nodes, set of pointing-to nodes
    buildGraph(map, visited, words);

    StringBuilder sb=new StringBuilder();
    for (int i=0; i<26; i++) {
      if (visited[i]==0) { // in graph and has NOT been visited
        if (!dfs(visited, i, map, sb)) return "";
      }
    }
    return sb.toString();
  }

  private void buildGraph(Map<Integer, Set<Integer>> map, int[] visited, String[] words) {
    for (String str : words) {
      for (char c : str.toCharArray()) {
        visited[c-'a']=0;
      }
    }
    for (int i=0; i<words.length-1; i++) {
      String w1=words[i], w2=words[i+1];
      int min=Math.min(w1.length(), w2.length());
      for (int j=0; j<min; j++) {
        if (w1.charAt(j)!=w2.charAt(j)) {
          char c1=w1.charAt(j), c2=w2.charAt(j);
          if (!map.containsKey(c1-'a')) map.put(c1-'a', new HashSet());
          map.get(c1-'a').add(c2-'a');
          break;
        }
      }
    }
  }

  private boolean dfs(int[] visited, int ch, Map<Integer, Set<Integer>> map, StringBuilder sb) {
    if (visited[ch]==1) return false;
    if (visited[ch]==2) return true;
    visited[ch]=1;
    if (map.containsKey(ch) && map.get(ch).size()>0) {
      for (Integer i : map.get(ch)) {
        if (!dfs(visited, i, map, sb)) return false;
      }
    }
    sb.insert(0, (char)(ch+'a'));
    visited[ch]=2;
    return true;
  }
}
