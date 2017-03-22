package com.google.bfs.dfs.bfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by ychang on 3/5/2017.
 */
public class WordLadderII {
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> res = new LinkedList();
    /**
     * must convert List to HashSet to avoid TLE, because list.contains() is much slower than HashSet.contains()
     */
    Set<String> dict = new HashSet(wordList);
    dict.remove(beginWord);
    Queue<String> queue = new LinkedList();
    queue.offer(beginWord);
    /**
     * this map is use to store a word's all prev words from beginWord side
     */
    Map<String, Set<String>> map = new HashMap();
    Set<String> secondLastWords = new HashSet();
    int len = beginWord.length();

    while (!queue.isEmpty() && secondLastWords.size()==0) {
      int size = queue.size();
      Set<String> removeStrings = new HashSet();
      for (int i = 0; i<size; i++) {
        String word = queue.poll();
        for (int j = 0; j<len; j++) {
          char[] charArray = word.toCharArray();
          for (char ch = 'a'; ch<='z'; ch++) {
            charArray[j] = ch;
            String newWord = String.valueOf(charArray);
            if (!newWord.equals(word) && dict.contains(newWord)) {
              /** this Java 8 is slower than the below
               map.computeIfAbsent(newWord, k -> new HashSet()).add(word);
               */
              if (!map.containsKey(newWord))
                map.put(newWord, new HashSet<>());
              map.get(newWord).add(word);
              /**
               Notice, we should NOT put !queue.contains(newWord) in line 41, because although queue contains newWord,
               that maybe from another route, we still need add entry to map to record this route. check
               !queue.contains(newWord) is just to avoid add newWord twice in queue
               */
              if (newWord.equals(endWord)) {
                secondLastWords.add(word);
                break; // this break will out for one position letter replace, but still go to next position
              } else if (!queue.contains(newWord)) {
                queue.offer(newWord);
              }
              removeStrings.add(newWord);
            }
          }
        }
      }
      // dict is like a un-visited word lib
      dict.removeAll(removeStrings);
    }

    for (String word : secondLastWords) {
      List<String> list = new LinkedList();
      list.add(endWord);
      dfs(map, list, word, beginWord, res);
    }

    return res;
  }

  private void dfs(Map<String, Set<String>> map, List<String> list, String start, String beginWord, List<List<String>> res) {
    list.add(0, start);
    if (start.equals(beginWord)) {
      res.add(new LinkedList(list));
    } else {
      Set<String> words = map.get(start);
      for (String word : words) {
        dfs(map, list, word, beginWord, res);
        list.remove(0);
      }
    }
  }
}
