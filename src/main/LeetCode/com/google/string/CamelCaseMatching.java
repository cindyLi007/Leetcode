package com.google.string;

import java.util.ArrayList;
import java.util.List;

public class CamelCaseMatching {
    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String word : queries) {
            res.add(match(pattern, word));
        }
        return res;
    }

    private static boolean match(String pattern, String word) {
        int i=0, j=0;
        while (i<pattern.length() && j<word.length()) {
            char pc = pattern.charAt(i), wc = word.charAt(j);
            if (Character.isUpperCase(pc) && Character.isUpperCase(wc)) {
                if (pc!=wc) return false;
                i++; j++;
            } else if (Character.isLowerCase(pc) && Character.isLowerCase(wc)) {
                if (pc==wc) {
                    i++; j++;
                } else {
                    j++;
                }
            } else if (Character.isUpperCase(pc)) {
                j++;
            } else {
                return false;
            }
        }
        if (j==word.length()) {
            return i==pattern.length();
        } else {
            while (j<word.length()) {
                if (Character.isUpperCase(word.charAt(j++))) return false;
            }
        }
        return true;
    }

    public static void main(String... args) {
        String[] queries = new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        List<Boolean> res_1 = camelMatch(queries, "FB");
        List<Boolean> res_2 = camelMatch(queries, "FoBa");
        List<Boolean> res_3 = camelMatch(queries, "FoBaT");
        for (Boolean r : res_3) {
            System.out.print(r + ", ");
        }
        System.out.println();
    }
}
