package com.google.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AutocompleteSystem {
  Trie root;
  String prefix;

  public AutocompleteSystem(String[] sentences, int[] times) {
    root = new Trie();
    for (int i = 0; i < sentences.length; i++) {
      root.insert(sentences[i], times[i]);
    }
    prefix = "";
  }

  public List<String> input(char c) {
    if (c=='#') {
      root.insert(prefix, 1);
      prefix = "";
      return Collections.emptyList();
    }
    prefix += c;
    List<Sentence> list = root.search(prefix);
    Collections.sort(list);
    return list.subList(0, Math.min(3, list.size())).stream().map(o->o.s).collect(Collectors.toList());
  }

  class Trie {
    Trie[] children;
    int times;

    Trie() {
      children = new Trie[27];
      times = 0;
    }

    public void insert(String sentence, int time) {
      insert(this, sentence, 0, time);
    }

    // 我们只set times in the sentence最后对应的char，并且不保存sentences in every node，这是Trie结构的中心思想, save space
    private Trie insert(Trie node, String s, int idx, int time) {
      if (node == null) node = new Trie();
      if (idx < s.length()) {
        char c = s.charAt(idx);
        int next = c == ' ' ? 26 : c - 'a';
        node.children[next] = insert(node.children[next], s, idx + 1, time);
      } else {
        node.times += time;
      }
      return node;
    }

    public List<Sentence> search(String s) {
      // First find the node correspond to the last char in s
      Trie node = search(this, s, 0);
      if (node == null) return Collections.emptyList();

      // we need collect all sentences in this Trie node and it's sub nodes
      List<Sentence> res = new ArrayList<>();
      traverse(node, s, res);
      return res;
    }

    private void traverse(Trie node, String s, List<Sentence> res) {
      if (node.times > 0) {
        res.add(new Sentence(s, node.times));
      }
      for (char c = 'a'; c <= 'z'; c++) {
        if (node.children[c-'a'] != null) {
          traverse(node.children[c-'a'], s+c, res);
        }
      }
      if (node.children[26] != null) {
        traverse(node.children[26], s+' ', res);
      }
    }

    private Trie search(Trie node, String s, int idx) {
      if (node == null || idx == s.length()) {
        return node;
      }
      char c = s.charAt(idx);
      int next = c == ' ' ? 26 : c - 'a';
      return search(node.children[next], s, idx + 1);
    }
  }

  class Sentence implements Comparable<Sentence> {
    String s;
    int times;

    Sentence(String s, int times) {
      this.s = s;
      this.times = times;
    }

    @Override
    public int compareTo(Sentence that) {
      return this.times == that.times ? this.s.compareTo(that.s) : that.times - this.times;
    }
  }

  /**
   * ["AutocompleteSystem","input","input","input","input"]
   * [[["i love you","island","iroman","i love leetcode"],[5,3,2,2]],["i"],[" "],["a"],["#"]]
   */
  public static void main(String... args) {
    String[] sentence = new String[]{"i love you", "island", "iroman", "i love leetcode"};
    AutocompleteSystem autocompleteSystem = new AutocompleteSystem(sentence, new int[]{5, 3, 2, 2});
    List<String> res = autocompleteSystem.input('i');
    print(res);
    res = autocompleteSystem.input(' ');
    print(res);
    res = autocompleteSystem.input('a');
    print(res);
    res = autocompleteSystem.input('#');
    print(res);
  }

  private static void print(List<String> res) {
    for (String s : res) {
      System.out.print(s + ",   ");
    }
    System.out.println();
  }
}
