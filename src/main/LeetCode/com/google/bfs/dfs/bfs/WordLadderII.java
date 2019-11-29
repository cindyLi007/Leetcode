package com.google.bfs.dfs.bfs;

import java.util.*;

/**
 * Created by ychang on 3/5/2017.
 */
public class WordLadderII {
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> res = new ArrayList();
    Set<String> D = new HashSet(wordList);
    Queue<String> queue = new ArrayDeque();
    queue.offer(beginWord);
    Map<String, Set<String>> map = new HashMap();
    Set<String> remove = new HashSet();

    // Time: O(N * L * L)
    while (!queue.isEmpty() && !map.containsKey(endWord)) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String word = queue.poll();
        // O(L * L)
        for (int j = 0; j < word.length(); j++) {
          char[] array = word.toCharArray();
          for (char c = 'a'; c <= 'z'; c++) {
            array[j] = c;
            String t = String.valueOf(array);
            if (D.contains(t)) {
              if (remove.add(t)) queue.offer(t);
              map.computeIfAbsent(t, o -> new HashSet()).add(word);
              if (t.equals(endWord)) break;
            }
          }
        }
      }
      D.removeAll(remove);
      remove.clear();
    }
    // Need first check whether we have answer, if no, directly return empty list
    if (map.containsKey(endWord))
      dfs(beginWord, endWord, map, res, new ArrayList());

    return res;
  }

  private void dfs(String begin, String end, Map<String, Set<String>> map, List<List<String>> res, List<String> list) {
    list.add(end);
    if (end.equals(begin)) {
      List<String> t = new ArrayList(list);
      Collections.reverse(t);
      res.add(t);
    } else {
      for (String s : map.get(end)) {
        dfs(begin, s, map, res, list);
      }
    }
    list.remove(list.size() - 1);
  }

}
