package com.google.trie;

class StreamChecker {
  Trie root;
  StringBuilder query;

  public StreamChecker(String[] words) {
    root = new Trie();
    for (String s : words) {
      StringBuilder sb = new StringBuilder(s);
      root.insert(sb.reverse().toString());
    }
    query = new StringBuilder();
  }

  public boolean query(char letter) {
    query.insert(0, letter);
    boolean res = root.search(query.toString());
    if (res) query = new StringBuilder();
    return res;
  }

  class Trie {
    Trie[] children;
    boolean isWord;

    Trie() {
      children = new Trie[26];
    }

    boolean search(String word) {
      Trie node = search(this, word, 0);
      return node != null && node.isWord;
    }

    Trie search(Trie node, String word, int idx) {
      if (node==null || node.isWord || idx == word.length()) return node;
      int c = word.charAt(idx) - 'a';
      return search(node.children[c], word, idx+1);
    }

    void insert(String word) {
      insert(this, word, 0);
    }

    Trie insert(Trie node, String word, int index) {
      if (node==null) node = new Trie();
      if (index == word.length()) {
        node.isWord = true;
        return node;
      }
      int c = word.charAt(index) - 'a';
      node.children[c] = insert(node.children[c], word, index+1);
      return node;
    }
  }

  public static void main(String... args) {
    StreamChecker streamChecker = new StreamChecker(new String[]{"cd", "f", "kl"});
    streamChecker.query('a');
    streamChecker.query('b');
    streamChecker.query('c');
    streamChecker.query('d');

  }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */