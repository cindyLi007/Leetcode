package com.google.tire;

/**
 * Created by grchan on 8/2/2018
 * Leetcode 208. Implement Trie
 */
public class Trie {
  Trie[] next;
  boolean isWord;

  public Trie() {
    next = new Trie[26];
  }

  public void insert(String word) {
    insert(this, word, 0);
  }

  private Trie insert(Trie node, String word, int d) {
    if (node==null) node=new Trie();
    if (word.length()==d) {
      node.isWord=true;
      return node;
    }
    int idx = word.charAt(d)-'a';
    node.next[idx] = insert(node.next[idx], word, d+1);
    return node;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    Trie res = search(this, word, 0);
    return res!=null && res.isWord;
  }

  private Trie search(Trie node, String word, int d) {
    if (node==null || word.length()==d) return node;
    int idx = word.charAt(d)-'a';
    return search(node.next[idx], word, d+1);
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    return search(this, prefix, 0)!=null;
  }

}
