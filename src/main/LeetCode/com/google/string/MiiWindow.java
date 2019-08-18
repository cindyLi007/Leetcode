package com.google.string;

import java.util.*;

public class MiiWindow {
    public static String minWindow(String s, String t) {
        int M = t.length(), N = s.length(), min = Integer.MAX_VALUE;
        String res = "";
        if (N<M) return res;
        Map<Character, Integer> map = new HashMap();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0, count=0;
        for (int right = 0; right<N; right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                if (map.get(c)>=0)
                    count++;
                while (count==M) {
                    if (min > right-left+1) {
                        min = right - left + 1;
                        res = s.substring(left, right+1);
                    }
                    char c1 = s.charAt(left++);
                    if (map.containsKey(c1)) {
                        map.put(c1, map.get(c1)+1);
                        if (map.get(c1)>0) count--;
                    }
                }
            }
        }
        return res;
    }

    public String minWindow_simplified(String s, String t) {
        int[] map = new int[256];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int left=0, right=0, count=t.length(), res=Integer.MAX_VALUE;
        String str="";
        while (right<s.length()) {
            char c = s.charAt(right++);
            /**
             * no matter whether a char in the map, update map
             */
            map[c]--;
            // if map[c]>=0 mean we hit a char in T
            if (map[c]>=0) count--;

            while (count==0) {
                if (right-left<res) {
                    res=right-left;
                    str=s.substring(left, right);
                }
                // kick out one char from left
                c=s.charAt(left++);
                map[c]++;
                if (map[c]>0) count++;
            }
        }
        return str;
    }

    public static void main(String... args) {
        String res = minWindow("ADOBECODEBANC", "ABC");
        System.out.println(res);
    }
}
