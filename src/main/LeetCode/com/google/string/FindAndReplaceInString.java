package com.google.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
 * Output: "eeebffff"
 * Explanation: "a" starts at index 0 in S, so it's replaced by "eee".
 * "cd" starts at index 2 in S, so it's replaced by "ffff".
 *
 * Input: S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
 * Output: "eeecd"
 * Explanation: "ab" starts at index 0 in S, so it's replaced by "eee".
 * "ec" doesn't starts at index 2 in the original S, so we do nothing.
 */
// Time: O(NlgN), Space: O(N)
public class FindAndReplaceInString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int N = S.length();
        List<Node> list = new ArrayList<>();
        for (int i=0; i<indexes.length; i++) {
            list.add(new Node(indexes[i], sources[i], targets[i]));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (Node node : list) {
            if (node.idx < 0) continue;;
            if (node.idx >= N) break;
            if (!node.source.equals(S.substring(node.idx, node.idx + node.source.length()))) continue;
            sb.append(S, start, node.idx).append(node.target);
            start = node.idx + node.source.length();
        }
        sb.append(S.substring(start));
        return sb.toString();
    }

    class Node implements Comparable<Node> {
        int idx;
        String source, target;

        Node(int i, String s, String t) {
            idx = i;
            source = s;
            target = t;
        }

        @Override
        public int compareTo(Node o) {
            return this.idx - o.idx;
        }
    }

    // Time: O(N + M), Space: O(M)
    public String findReplaceString_direct(String S, int[] indexes, String[] sources, String[] targets) {
        int N = S.length();
        int[] match = new int[N];
        Arrays.fill(match, -1);
        for (int i=0; i<indexes.length; i++) {
            if (S.substring(indexes[i], indexes[i]+sources[i].length()).equals(sources[i])) {
                match[indexes[i]] = i;
            }
        }
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (idx<N) {
            if (match[idx]>=0) {
                sb.append(targets[match[idx]]);
                idx+=sources[match[idx]].length();
            } else {
                sb.append(S.charAt(idx++));
            }
        }
        return sb.toString();
    }

    public static void main(String... args) {
        FindAndReplaceInString findAndReplaceInString = new FindAndReplaceInString();
        String result = findAndReplaceInString.findReplaceString("abcd", new int[]{0, 2}, new String[]{"a", "cd"}, new String[]{"eee", "ffff"});
        System.out.println(result);

        String result_1 = findAndReplaceInString.findReplaceString("abcd", new int[]{0, 2}, new String[]{"ab", "ec"}, new String[]{"eee", "ffff"});
        System.out.println(result_1);

        String result_2 = findAndReplaceInString.findReplaceString("vmokgggqzp", new int[]{3, 5, 1},
                new String[]{"kg","ggq","mo"}, new String[]{"s", "so", "bfr"});
        System.out.println(result_2);
    }
}
