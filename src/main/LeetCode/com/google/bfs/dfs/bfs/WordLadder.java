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
            if (subWord.equals(word) || !dict.contains(subWord))
              continue;
            if (subWord.equals(endWord))
              return depth + 1;
            dict.remove(subWord);
            queue.offer(subWord);
          }
        }
      }
      depth++;
    }
    return 0;
  }
}
