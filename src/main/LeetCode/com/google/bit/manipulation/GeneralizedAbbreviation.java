package com.google.bit.manipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 320
 * Write a function to generate the generalized abbreviations of a word.
 *
 * Note: The order of the output does not matter.
 *
 * Example:
 *
 * Input: "word"
 * Output:
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 */
// Time: O(n*2^n), n is word length
public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        for (int j=0; j<(1<<word.length()); j++) {
            StringBuilder sb = new StringBuilder();
            int idx=0, count=0;
            int x=j;
            for (int i=0; i<word.length(); i++) {
                if (((x>>i) & 1) == 1) {
                    count++;
                } else {
                    if (count>0) {
                        sb.append(count);
                        count=0;
                    }
                    sb.append(word.charAt(i));
                }
            }
            if (count>0) {
                sb.append(count);
            }
            res.add(sb.toString());
        }
        return res;
    }
}
