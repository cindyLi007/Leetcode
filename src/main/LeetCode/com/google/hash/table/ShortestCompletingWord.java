package com.google.hash.table;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ShortestCompletingWord {
    // Time: O(N), Space: O(1)
    // For this question, sort by string length will slow the performance, and since there are only 26 lower char, use
    // array is faster than use hash map
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String lp = licensePlate.toLowerCase();
        int[] lpA = new int[26];
        for (char c : lp.toCharArray()) {
            if (Character.isLetter(c)) {
                lpA[c-'a']++;
            }
        }
        String res = "";
        for (String w :words) {
            int[] wA = new int[26];
            for (char c : w.toCharArray()) {
                if (Character.isLetter(c)) {
                    wA[c-'a']++;
                }
            }
            boolean found = true;
            for (int i=0; i<26; i++) {
                if (wA[i]<lpA[i]) {
                    found=false;
                    break;
                }
            }
            if (found && (res.length()==0 || res.length()>w.length())) {
                res = w;
            }
        }
        return res;
    }
}
