package com.google.bfs.dfs.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by ychang on 3/21/2017.
 */
public class WordLadder {
  /**
   * this one can beat 60%
   */
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> dict = new HashSet(wordList);
    Queue<String> queue = new LinkedList();
    queue.add(beginWord);
    int depth = 1, len = beginWord.length();
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i<size; i++) {
        String word = queue.poll();
        for (int j = 0; j<len; j++) {
          char[] wordChar = word.toCharArray();
          for (char c = 'a'; c<='z'; c++) {
            wordChar[j] = c;
            String subWord = String.valueOf(wordChar);
            if (dict.contains(subWord)) {
              if (subWord.equals(endWord))
                return depth + 1;
              dict.remove(subWord);
              queue.offer(subWord);
            }
          }
        }
      }
      depth++;
    }
    return 0;
  }

  /**
   * this one can beat 89%. That is because FIRST it uses 2-end BFS to do bi-direct search: The idea behind bidirectional
   * search is to run two simultaneous searches—one forward from the initial state and the other backward from the goal
   * —hoping that the two searches meet in the middle. The motivation is that b^(d/2) + b^(d/2) is much less than b^d.
   * b is branch factor, d is depth. SECOND it uses HashSet instead of LinkedList as Queue
   */
  public int ladderLength_twoEnd_BFS(String beginWord, String endWord, List<String> wordList) {
    Set<String> dict = new HashSet(wordList);
    if (!dict.contains(endWord))
      return 0;
    int len = beginWord.length();
    Set<String> bQueue = new HashSet();
    bQueue.add(beginWord);
    Set<String> eQueue = new HashSet();
    eQueue.add(endWord);
    int res = 1;
    dict.remove(endWord);

    // must both queue is NOT empty, otherwise that means there no edge connect 2 nodes
    while (!bQueue.isEmpty() && !eQueue.isEmpty()) {
      if (bQueue.size()>eQueue.size()) {
        Set<String> temp = bQueue;
        bQueue = eQueue;
        eQueue = temp;
      }
      // always assume bQueue is smaller one, and always go through the smaller one,
      Set<String> temp = new HashSet();
      for (String cur : bQueue) {
        for (int j = 0; j<len; j++) {
          char[] ch = cur.toCharArray();
          for (char c = 'a'; c<='z'; c++) {
            ch[j] = c;
            String s = String.valueOf(ch);
            if (eQueue.contains(s))
              return res + 1;
            if (dict.contains(s)) {
              temp.add(s);
              dict.remove(s);
            }
          }
        }
      }
      bQueue = temp;
      res++;
    }

    return 0;
  }
}