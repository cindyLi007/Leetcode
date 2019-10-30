package com.google.backtracking;

import java.util.HashMap;
import java.util.Map;

public class LetterTilePossibilities {

  int N;
  public int numTilePossibilities(String tiles) {
    N = tiles.length();

    // count very char number
    // Time: O(N), Space: O(N)
    Map<Character, Integer> map = new HashMap();
    for (char c : tiles.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    // from "" dfs with updated map, and record number
    return dfs("", map);
  }

  // Time: O(N^M), Space: O(N), M is the number of distinct chars in tiles
  public int dfs(String prefix, Map<Character, Integer> map) {
    int count = 0;
    if (prefix.length() == N) return count;
    for (Character c : map.keySet()) {
      if (map.get(c)>0) {
        map.put(c, map.get(c)-1);
        count++;
        count += dfs(prefix + c, map);
        map.put(c, map.get(c)+1);
      }
    }
    return count;
  }

  public static void main(String... args) {
    LetterTilePossibilities letterTilePossibilities = new LetterTilePossibilities();
    System.out.println(letterTilePossibilities.numTilePossibilities("AAB"));
  }
}
