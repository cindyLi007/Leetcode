package com.google.tire;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Created by ychang on 12/3/2016.
 */
public class PalindromePair {
  public List<List<Integer>> palindromePairs_HashMap(String[] words) {
    List<List<Integer>> result = new LinkedList();
    if (words.length<=1) return result;
    Map<String, Integer> map = Maps.newHashMap();
    for (int i=0; i<words.length; i++) {
      map.put(words[i], i);
    }

    for (int i=0; i<words.length; i++) {
      String word = words[i];
      for (int j=word.length(); j>=0; j--) {
        String str1 = word.substring(j);
        String str2 = word.substring(0, j);
        if (isPalindrome(str1)) {
          String prefix = new StringBuilder(str2).reverse().toString();
          Integer index = map.get(prefix);
          if (index!=null && i!=index) {
            result.add(Arrays.asList(i, index));
          }
        }
        if (str2.length()!=0 && isPalindrome(str2)) {
          String prefix = new StringBuilder(str1).reverse().toString();
          Integer index = map.get(prefix);
          if (index!=null && i!=index) {
            result.add(Arrays.asList(index, i));
          }
        }
      }
    }
    return result;
  }

  boolean isPalindrome(String s) {
    if (s==null) return true;
    int i=0, j=s.length()-1;
    while (i<j) {
      if (s.charAt(i++) != s.charAt(j--)) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    PalindromePair palindromePair = new PalindromePair();
//    String[] words = new String[]{"bat", "tab", "cat"};
    String[] words = new String[]{"abcd", "dcba", "lls", "tts", "sssll"};
//    String[] words = new String[]{"a", ""};
    List<List<Integer>> lists = palindromePair.palindromePairs_HashMap(words);
    lists.stream().forEach(System.out::print);
  }

  private List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> rst = Lists.newArrayList();
    TrieNode root = new TrieNode();
    for (int i = 0; i<words.length; i++)
      addWord(words[i], root, i);
    for (int i=0; i<words.length; i++) {
      search(words, i, root, rst);
    }
    return rst;
  }

  /*
    search all words can be append words[i]
   */
  private void search(String[] words, int i, TrieNode root, List<List<Integer>> rst) {
    for (int j=0; j<words[i].length(); j++) {
      if (root.index>=0 && root.index!=i && isPalindrome(words[i], j, words[i].length()-1)) {
        rst.add(Arrays.asList(i, root.index));
      }
      root = root.next[words[i].charAt(j)-'a'];
      if (root==null) return;
    }
    for (int j : root.list) {
      if (i==j) continue;
      rst.add(Arrays.asList(i, j));
    }
  }

  /*
    build the Trie Tree for search, so should start from the end of the word
    When search from a word, start from the beginning of that word to find a word whose last letter match it's first char
   */
  private void addWord(String word, TrieNode root, int index) {
    for (int i = word.length() - 1; i>=0; i--) {
      int j = word.charAt(i) - 'a';
      if (root.next[j]==null)
        root.next[j] = new TrieNode();
      if (isPalindrome(word, 0, i))
        root.list.add(index);
      root = root.next[j];
    }
    root.list.add(index);
    root.index = index;
  }

  private boolean isPalindrome(String word, int start, int end) {
    while (start<end) {
      if (word.charAt(start++)!=word.charAt(end--))
        return false;
    }
    return true;
  }

  class TrieNode {
    TrieNode[] next;
    int index; // if index>=0, means this node is a word in the array, otherwise this node is a middle char
    List<Integer> list; // store all indexes of words whose substring from (i, len) is a Palindrome, where i is the next layer

    public TrieNode() {
      next = new TrieNode[26];
      index = -1;
      list = Lists.newArrayList();
    }
  }
}
