package com.google.hash.table;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * leetcode 734
 * Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs,
 * determine if two sentences are similar.
 */
public class SentenceSimilar {
    // Time: O(N + M), N is # of pairs in list, M is word in words1/words2, Space: O(N)
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        // build up a Set<word1#word2>, that is much faster to build a Map<String, List<String>>
        Set<String> set = new HashSet<>();
        for (List<String> pair : pairs) {
            String s1 = pair.get(0), s2 = pair.get(1);
            set.add(s1+"#"+s2);
        }
        for (int i=0; i<words1.length; i++) {
            String s1 = words1[i], s2=words2[i];
            if (!s1.equals(s2) && !set.contains(s1+"#"+s2) && !set.contains(s2+"#"+s1)) {
                return false;
            }
        }
        return true;
    }
}
