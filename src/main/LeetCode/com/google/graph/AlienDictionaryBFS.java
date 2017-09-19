package com.google.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by ychang on 6/6/2017.
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
 * You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of
 * this new language. Derive the order of letters in this language.
 * Given the following words in dictionary, [ "wrt", "wrf", "er", "ett", "rftt"] The correct order is: "wertf".
 * this can beat 74%
 */
public class AlienDictionaryBFS {
  public String alienOrder(String[] words) {
    /**
     * we must first determine all chars appear in all words, if there is no inDegree to this char, we treat it as init-nodes
     * inDegree[i]==-1 means not existing, 0 mean no in-edges, >0 mean number of in-edges
     */
    int[] inDegree=new int[26];
    Arrays.fill(inDegree, -1);
    Map<Integer, Set<Integer>> graph = new HashMap();
    int charNum = buildGraph(words, graph, inDegree);

    // construct a zero-inDegree queue
    Queue<Integer> queue = new LinkedList();
    for (int i=0; i<26; i++) {
      if (inDegree[i]==0) queue.offer(i);
    }

    StringBuilder sb = new StringBuilder();
    // use BFS to sort
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      sb.append((char)(cur+'a'));
      if (graph.containsKey(cur) && graph.get(cur).size()>0) {
        for (int i : graph.get(cur)) {
          inDegree[i]--;
          if (inDegree[i]==0) queue.offer(i);
        }
      }
    }
    /** we need make sure finally all nodes's inDegree is 0 (we traverse all nodes), if not, that means we have a loop
     * among some nodes, which make those nodes' inDegree can not be 0, so we did not add them to queue
     */
    return sb.length()==charNum ? sb.toString() : "";
  }

  /**
   * @return number of unique char in all words, it is used to verify whether we traverse all nodes using BFS
   */
  private int buildGraph(String[] words, Map<Integer, Set<Integer>> map, int[] inDegree) {
    int res=0;
    for (String word : words) {
      for (char c : word.toCharArray()) {
        if (inDegree[c-'a']==-1) res++;
        inDegree[c-'a']=0;
      }
    }
    for (int i=0; i<words.length-1; i++) {
      String w1=words[i], w2=words[i+1];
      int min=Math.min(w1.length(), w2.length());
      for (int j=0; j<min; j++) {
        if (w1.charAt(j)!=w2.charAt(j)) {
          int c1=w1.charAt(j)-'a', c2=w2.charAt(j)-'a';
          if (!map.containsKey(c1)) map.put(c1, new HashSet());
          /**
           * only when set does not contain c2, add it and update inDegree[c2], because each edge is unique in graph,
           * we should avoid to add more inDegree for same edges
           */
          if (!map.get(c1).contains(c2)) {
            map.get(c1).add(c2);
            inDegree[c2]++;
          }
          break;
        }
      }
    }
    return res;
  }
}
