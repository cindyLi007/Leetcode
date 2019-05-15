package com.google.bit.manipulation;

/**
 * Leetcode 318
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not
 * share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 */
public class MaxProductOfWordLength {
    // Time: O(N*N)
    public int maxProduct(String[] words) {
        int N=words.length;
        int[] mask = new int[N];
        // N * m (m is average word length)
        for (int i=0; i<N; i++) {
            // use an int as a mask, each bit is indicate whether a letter is included in the word
            for (char c : words[i].toCharArray()) {
                mask[i] |= 1 << (c-'a');
            }
        }
        int res = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if ((mask[i] & mask[j])==0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
