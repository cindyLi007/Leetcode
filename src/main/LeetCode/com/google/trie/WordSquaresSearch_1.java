package com.google.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordSquaresSearch_1 {
  List<List<String>> res = new ArrayList();
  int len;
  Trie root;

  public List<List<String>> wordSquares(String[] words) {
    len = words[0].length();
    root = new Trie();
    for (String w : words) {
      root.insert(w);
    }
    List<String> list = new ArrayList();
    for (String w : words) {
      list.add(w);
      search(list, 1, root);
      list.remove(list.size()-1);
    }
    return res;
  }

  private void search(List<String> list, int d, Trie root) {
    if (d==len) {
      res.add(new ArrayList(list));
    } else {
      StringBuilder prefix = new StringBuilder();
      for (int i=0; i<d; i++) {
        prefix.append(list.get(i).charAt(d));
      }
      List<String> next = root.find(prefix.toString());
      for (String s : next) {
        list.add(s);
        search(list, d+1, root);
        list.remove(list.size()-1);
      }
    }
  }

  class Trie {
    Trie[] children;
    List<String> words; // word set including prefix till this Trie Node

    public Trie() {
      words = new ArrayList();
      children = new Trie[26];
    }

    public void insert(String word) {
      insert(this, word, 0);
    }

    private Trie insert(Trie node, String word, int d) {
      if (node==null) node = new Trie();
      node.words.add(word);
      if (d<len) {
        int c = word.charAt(d) - 'a';
        node.children[c] = insert(node.children[c], word, d+1);
      }
      return node;
    }

    public List<String> find(String word) {
      Trie node = find(this, word, 0);
      if (node==null) return Collections.emptyList();
      return node.words;
    }

    private Trie find(Trie node, String word, int d) {
      if (node==null || d==word.length()) return node;
      int c = word.charAt(d) - 'a';
      return find(node.children[c], word, d+1);
    }
  }

  public static void main(String... args) {
    WordSquaresSearch_1 wordTemp = new WordSquaresSearch_1();
    wordTemp.wordSquares(new String[]{"area","lead","wall","lady","ball"});
  }
}
