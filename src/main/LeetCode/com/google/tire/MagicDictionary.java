package com.google.tire;

import java.util.*;
import java.util.stream.Collectors;

// Time: O(26*N*N), N is the average len of words
class MagicDictionary {
    Trie root;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        root=new Trie();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            root.insert(root, word, 0);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            char[] sc = word.toCharArray();
            for (char c='a'; c<='z'; c++) {
                if (c==ch) continue;
                sc[i]=c;
                if (root.search(root, String.valueOf(sc))) return true;
            }
        }
        return false;
    }

    class Trie {
        Trie[] next;
        boolean isWord;

        Trie() {
            next=new Trie[26];
        }

        boolean search(Trie root, String word) {
            Trie node = search(root, word, 0);
            return node!=null && node.isWord==true;
        }

        private Trie search(Trie root, String word, int d) {
            if (root==null || word.length()==d) return root;
            int idx = word.charAt(d) - 'a';
            return search(root.next[idx], word, d+1);
        }

        Trie insert(Trie root, String word, int d) {
            if (root==null) root=new Trie();
            if (word.length()==d) root.isWord=true;
            else {
                int idx = word.charAt(d)-'a';
                root.next[idx]=insert(root.next[idx], word, d+1);
            }
            return root;
        }
    }

    public static void main(String... args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(magicDictionary.search("hello"));
        System.out.println(magicDictionary.search("hhllo"));
        System.out.println(magicDictionary.search("hell"));
        System.out.println(magicDictionary.search("leetcoded"));
    }

    public boolean isReflected(int[][] points) {
        int N = points.length;
        if (N<=1) return false;
        Map<Integer, Set<Integer>> map = new HashMap();
        for (int[] p : points) {
            int x = p[0], y = p[1];
            map.computeIfAbsent(y, k-> new HashSet<Integer>()).add(x);
        }
        for (Integer k : map.keySet()) {
            if (map.get(k).size()>1) return true;
        }
        return false;
    }
}

