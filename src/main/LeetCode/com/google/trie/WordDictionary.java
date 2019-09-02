package com.google.trie;

/**
 * Created by ychang on 5/4/2017.
 */
public class WordDictionary {
  TrieNode root;

  /**
   * Initialize your data structure here.
   */
  public WordDictionary() {}

  /**
   * Adds a word into the data structure.
   */
  public void addWord(String word) {
    root = addWord(root, word, 0);
  }

  private TrieNode addWord(TrieNode node, String word, int d) {
    if (node==null)
      node = new TrieNode();
    if (word.length()==d)
      node.isWord = true;
    else {
      int c = word.charAt(d) - 'a';
      node.next[c] = addWord(node.next[c], word, d + 1);
    }
    return node;
  }

  /**
   * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
   */
  public boolean search(String word) {
    TrieNode node = search(root, word, 0);
    return node!=null && node.isWord;
  }

  private TrieNode search(TrieNode node, String word, int d) {
    if (node==null || word.length()==d)
      return node;
    if (word.charAt(d)=='.') {
      for (int i = 0; i<26; i++) {
        TrieNode x = search(node.next[i], word, d + 1);
        if (x!=null && x.isWord)
          return x;
      }
      return null;
    } else {
      int c = word.charAt(d) - 'a';
      return search(node.next[c], word, d + 1);
    }
  }

  class TrieNode {
    TrieNode[] next;
    boolean isWord;

    TrieNode() {
      next = new TrieNode[26];
    }
  }
}

