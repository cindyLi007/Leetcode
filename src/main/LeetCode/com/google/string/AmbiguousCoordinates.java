package com.google.string;

import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates {
    public static List<String> ambiguousCoordinates(String S) {
        List<String> res = new ArrayList<>();
        String s = S.substring(1, S.length()-1);
        int N = s.length();
        for (int i = 1; i < N; i++) {
            List<String> first = dot(s.substring(0, i)), second = dot(s.substring(i));
            for (String s1 : first) {
                for (String s2 : second) {
                    res.add("(" + s1 + ", " + s2 + ")");
                }
            }
        }
        return res;
    }

    private static List<String> dot(String s) {
        List<String> res = new ArrayList<>();
        int N= s.length();

        // first check whether s is a valid String
        if (N>1 && s.charAt(0)=='0' && s.charAt(N-1)=='0') return res;

        // second cover all corner cases
        if (N == 1 || s.charAt(N-1)=='0') {
            res.add(s);
            return res;
        }

        if (s.charAt(0)=='0') {
            res.add("0." + s.substring(1));
        } else {
            res.add(s);
            for (int i=1; i<N; i++) {
                res.add(s.substring(0, i) + "." + s.substring(i));
            }
        }
        return res;
    }

    public static void main(String... args) {
        List<String> res = ambiguousCoordinates("(123)");
        for (String s : res) {
            System.out.print(s + ",  ");
        }
    }
}
