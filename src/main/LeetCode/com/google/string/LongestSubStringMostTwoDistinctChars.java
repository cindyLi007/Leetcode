package com.google.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubStringMostTwoDistinctChars {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] map = new int[256];
        int left = 0, right = 0, res = 0, count = 0;
        while (right < s.length()) {
            int c = s.charAt(right);
            if (map[c] == 0) count++;
            map[c]++;
            while (count > 2) {
                c = s.charAt(left++);
                map[c]--;
                if (map[c] == 0) count--;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    public static void main(String... args) {
//        int length = lengthOfLongestSubstringTwoDistinct("eceba");
        int length = lengthOfLongestSubstringTwoDistinct("ccaabbb");
        System.out.println(length);
    }
}
