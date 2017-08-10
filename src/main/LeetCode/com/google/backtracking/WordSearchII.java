package com.google.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 8/7/2017.
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
 * horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 * we use dfs, so we can label a cell which visited as '-', and recover the cell when out of dfs
 * the main idea is first build a TrieTree, which is constructed by all dict words, so when walk through the board,
 * check whether there is startWith or sameWord in the TrieTree with the board-walk-cell-letter-trace
 * if no, stop it, so need not go deeper.
 */
public class WordSearchII {
  public List<String> findWords(char[][] board, String[] words) {
    int M=board.length, N=board[0].length;
    Trie root = build(words);
    List<String> res = new LinkedList();
    for (int i=0; i<M; i++) {
      for (int j=0; j<N; j++) {
        dfs(board, M, N, i, j, root, res);
      }
    }
    return res;
  }

  private void dfs(char[][] board, int M, int N, int i, int j, Trie root, List<String> res) {
    if (root.word!=null) {
      res.add(root.word);
      root.word=null; // avoid duplication
    }
    if (i<0 || j<0 || i>=M || j>=N || board[i][j]=='-' || root.next[board[i][j]-'a']==null) return;
    char c = board[i][j];
    board[i][j]='-';
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    for (int[] dir : dirs) {
      dfs(board, M, N, i+dir[0], j+dir[1], root.next[c-'a'], res);
    }
    board[i][j]=c;
  }

  private Trie build(String[] words) {
    Trie root = new Trie();
    for (String word : words) {
      Trie node = root;
      for (char c : word.toCharArray()) {
        if (node.next[c-'a']==null) node.next[c-'a']=new Trie();
        node=node.next[c-'a'];
      }
      node.word = word;
    }
    return root;
  }

  class Trie {
    Trie[] next;
    /**
     * use TrieNode to record word, so need not pass prefix in dfs
     */
    String word;

    Trie() {
      next = new Trie[26];
    }
  }
}
