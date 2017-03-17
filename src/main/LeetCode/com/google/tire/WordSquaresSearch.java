package com.google.tire;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.google.common.collect.Lists;

/**
 * Created by ychang on 12/2/2016.
 */
public class WordSquaresSearch {
  public List<List<String>> wordSquares(String[] words) {
    TrieTree root = new TrieTree(words);
    List<List<String>> result = Lists.newLinkedList();
    for (String word : words) {
      List<String> list = Lists.newLinkedList();
      list.add(word);
      search(root, word.length(), 1, list, result);
    }
    return result;
  }

  public static void main(String[] args) {
    WordSquaresSearch was = new WordSquaresSearch();
    //    String[] words = new String[]{"wall", "area", "lead", "lady", "ball"};
//    String[] words = new String[]{"momy","oooo","yoyo"};
    //    String[] words = new String[]{"abat", "atal", "atan", "baba"};
    String[] words = new String[]{"ball", "area", "lead", "lady"};
    List<List<String>> result = was.wordSquares(words);
    result.stream().forEach(System.out::println);
  }

  void search(TrieTree root, int len, int depth, List<String> list, List<List<String>> result) {
    if (depth==len) {
      result.add(Lists.newLinkedList(list));
      return;
    }
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<list.size(); i++) {
      sb.append(list.get(i).charAt(depth));
    }
    String prefix = sb.toString();
    List<String> candidates = root.get(prefix);
    for (String next : candidates) {
      list.add(next);
      search(root, len, depth+1, list, result);
      list.remove(list.size()-1);
    }
  }

  class TrieNode {
    TrieNode[] children = new TrieNode[26];
    List<String> matchedWords = new LinkedList();
  }
  class TrieTree {
    TrieNode root = new TrieNode();

    TrieTree(String[] words) {
      for (String word : words) {
        TrieNode currentNode = root;
        for (int i=0; i<word.length(); i++) {
          int index = word.charAt(i) - 'a';
          if (Objects.isNull(currentNode.children[index]))
            currentNode.children[index]=new TrieNode();
          currentNode.matchedWords.add(word);
          currentNode = currentNode.children[index];
        }
      }
    }

    List<String> get(String prefix) {
      TrieNode node = get(root, prefix, 0);
      if (Objects.isNull(node)) return new LinkedList<>();
      return node.matchedWords;
    }

    TrieNode get(TrieNode root, String prefix, int depth) {
      if (Objects.isNull(root)) return null;
      if (prefix.length()==depth) return root;
      int index = prefix.charAt(depth) - 'a';
      return get(root.children[index], prefix, depth+1);
    }
  }
}
