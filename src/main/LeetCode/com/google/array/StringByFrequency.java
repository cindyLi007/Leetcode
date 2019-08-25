package com.google.array;

import java.util.Arrays;

public class StringByFrequency {

  public int[] numSmallerByFrequency(String[] queries, String[] words) {
    int N = queries.length, M = words.length;
    int[] res = new int[N], q = new int[N], w = new int[M];
    for (int i=0; i<N; i++) {
      q[i] = f(queries[i]);
    }
    for (int i=0; i<M; i++) {
      w[i] = f(words[i]);
    }
    Arrays.sort(w);
    for (int i=0; i<N; i++) {
      int c = Arrays.binarySearch(w, q[i]+1);
      if (c>0) {
        while (c>0 && w[c-1] == q[i]+1) c--;
        res[i] = M-c;
      }
      else {
        res[i] = M - (Math.abs(c)-1);
      }
    }
    return res;
  }

  private int f(String s) {
    int[] ch = new int[26];
    for (char c : s.toCharArray()) {
      ch[c-'a']++;
    }
    for (int i=0; i<26; i++) {
      if (ch[i]>0) return ch[i];
    }
    return 0;
  }

  public static void main(String... args) {
    StringByFrequency stringByFrequency = new StringByFrequency();
    String[] queries = new String[]{"aabbabbb","abbbabaa","aabbbabaa","aabba","abb","a","ba","aa","ba","baabbbaaaa","babaa","bbbbabaa"};
    String[] words = new String[]{"b","aaaba","aaaabba","aa","aabaabab","aabbaaabbb","ababb","bbb","aabbbabb","aab","bbaaababba","baaaaa"};
    int[] res = stringByFrequency.numSmallerByFrequency(queries, words);
    Arrays.stream(res).boxed().forEach(o-> System.out.print(o + ", "));

  }
}
