package com.google.minimax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// Leetcode 843
/**
 * The probability of two words with 0 match is (25/26)^6 = 80%. That is to say, for a candidate word, we have 80% chance
 * to see 0 match with the secret word. In this case, we had 80% chance to eliminate the candidate word and its "family"
 * words which have at least 1 match. Additionally, in order to delete a max part of words, we select a candidate who has
 * a big "family" (fewest 0 match with other words).
 */
public class GuessTheWord {
  public void findSecretWord(String[] wordlist, Master master) {
    while (wordlist.length > 0) {
      String s = preprocess(wordlist);
      int m = master.guess(s);
      if (m==6) return;
      List<String> wl = new ArrayList();
      for (String w : wordlist) {
        if (match(w, s, m)) wl.add(w);
      }
      wordlist = wl.toArray(new String[0]);
    }
  }

  private String preprocess(String[] wordlist) {
    int N = wordlist.length;
    Map<String, Integer> map = new HashMap();
    for (int i=0; i<N; i++) {
      String s = wordlist[i];
      for (int j=0; j<N; j++) {
        if (match(s, wordlist[j], 0)) {
          map.put(s, map.getOrDefault(s, 0) + 1);
          map.put(wordlist[j], map.getOrDefault(wordlist[j], 0) + 1);
        }
      }
    }
    String res = wordlist[0];
    for (String key : map.keySet()) {
      if (map.get(key) < N) {
        N = map.get(key);
        res = key;
      }
    }
    return res;
  }

  private boolean match(String word, String p, int m) {
    for (int i=0; i<6; i++) {
      if (word.charAt(i)==p.charAt(i)) m--;
    }
    return m==0;
  }

  class Master {

    public int guess(String s) {
      return 0;
    }
  }


}
