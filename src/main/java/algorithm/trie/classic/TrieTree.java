package algorithm.trie.classic;

import java.util.Objects;

/**
 * Created by ychang on 12/1/2016.
 */
public class TrieTree<V> {
  private TrieNode root;

  void put(String s, V value) {
    root = put(root, s, value, 0);
  }

  private TrieNode put(TrieNode root, String s, V value, int depth) {
    if (root==null) {
      root = new TrieNode();
    }
    if (depth==s.length()) {
      root.value = value;
      return root;
    }
    int i = s.charAt(depth) - 'a';
    root.next[i] = put(root.next[i], s, value, depth + 1);
    return root;
  }

  V get(String key) {
    TrieNode node = get(root, key, 0);
    if (Objects.isNull(node))
      return null;
    return (V) node.value;
  }

  private TrieNode get(TrieNode root, String key, int depth) {
    if (root==null)
      return null;
    if (key.length()==depth)
      return root;
    return get(root.next[key.charAt(depth)-'a'], key, depth + 1);
  }
}

class TrieNode {
  Object value;
  TrieNode[] next = new TrieNode[26];
}