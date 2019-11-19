package com.google.binary.search;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TopVotedCandidate {
  int N;
  Map<Integer, Integer> map;
  TreeMap<Integer, Integer> query;

  // Time: O(N)
  public TopVotedCandidate(int[] persons, int[] times) {
    map = new HashMap();
    query = new TreeMap();
    N = persons.length;
    int m = 0, label = -1;
    for (int i = 0; i < N; i++) {
      int v = persons[i];
      map.put(v, map.getOrDefault(v, 0) + 1);
      int count = map.get(v);
      if (count >= m) {
        label = v;
        m = count;
      }
      query.put(times[i], label);
    }
  }

  // O(lgT) T is # of timestamp
  public int q(int t) {
    return query.floorEntry(t).getValue();
  }


  public static void main(String... args) {
    int[] persons = new int[]{0, 1, 1, 0, 0, 1, 0};
    int[] time = new int[]{0, 5, 10, 15, 20, 25, 30};
    TopVotedCandidate topVotedCandidate = new TopVotedCandidate(persons, time);
    System.out.println(topVotedCandidate.q(3)); // 0
    System.out.println(topVotedCandidate.q(12)); // 1
    System.out.println(topVotedCandidate.q(25)); // 1
    System.out.println(topVotedCandidate.q(15)); // 0
    System.out.println(topVotedCandidate.q(24)); // 0
    System.out.println(topVotedCandidate.q(8)); // 1
  }

}
