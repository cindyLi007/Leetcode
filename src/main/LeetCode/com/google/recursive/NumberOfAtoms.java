package com.google.recursive;

import java.util.*;

/**
 * leetcode 726
 * Input: formula = "K4(ON(SO3)2)2"
 * Output: "K4N2O14S4"
 * Explanation:  The count_bruteForce of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
 */
public class NumberOfAtoms {
    int i=0, N; // dynamically move i
    public String countOfAtoms(String formula) {
        N=formula.length();
        Map<String, Integer> map = helper(formula);
        StringBuilder sb = new StringBuilder();
        // We could not directly sort map, but we can sort map keys to sort map
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (String s : keys) {
            sb.append(s);
            if (map.get(s)>1) sb.append(map.get(s));
        }
        return sb.toString();
    }

    private Map<String, Integer> helper(String f) {
        Map<String, Integer> map = new HashMap<>();
        // when we encounter ')' that means an inner formula end, we need return to the upper level
        while (i<N && f.charAt(i)!=')') {
            // when we encounter '(' that mean begin an inner formula.
            if (f.charAt(i)=='(') {
                i++;
                Map<String, Integer> inner = helper(f);
                for (String key : inner.keySet()) {
                    map.put(key, map.getOrDefault(key, 0) + inner.get(key));
                }
            } else {
                int start = i++;
                while (i<N && Character.isLowerCase(f.charAt(i))) i++;
                String name = f.substring(start, i);
                start=i;
                while (i<N && Character.isDigit(f.charAt(i))) i++;
                int m = start==i ? 1 : Integer.parseInt(f.substring(start, i));
                map.put(name, map.getOrDefault(name, 0) + m);
            }
        }
        // now i==N or f.charAt(i)==')' so that is the end of recursion, before we return we need multiply the number of all
        // atoms in the '(' to ')'
        int start = ++i;
        while (i<N && Character.isDigit(f.charAt(i))) i++;
        if (start<i) {
            int m = Integer.parseInt(f.substring(start, i));
            for (String name : map.keySet()) {
                map.put(name, map.get(name) * m);
            }
        }
        return map;
    }

    public static void main(String... args) {
        NumberOfAtoms numberOfAtoms = new NumberOfAtoms();
        String res = numberOfAtoms.countOfAtoms("K4(ON(SO3)2)2");
//        String res = numberOfAtoms.countOfAtoms("H2O");
//        String res = numberOfAtoms.countOfAtoms("Mg(OH)2");
        System.out.println(res);
    }

}
