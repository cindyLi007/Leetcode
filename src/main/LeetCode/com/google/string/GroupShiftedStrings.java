package com.google.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
    public static List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();
        // Time: O(N), Space: O(N)
        for (String s : strings) {
            map.computeIfAbsent(s.length(), k->new ArrayList<String>()).add(s);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key).size()==1 || key == 1) {
                res.add(map.get(key));
            } else {
                List<String> list = map.get(key);
                // Time: O(N^2 * Len)
                while (list.size()>0) {
                    String s1 = list.get(0);
                    List<String> cur = new ArrayList<>();
                    cur.add(s1);
                    for (int i=1; i<list.size(); i++) {
                        String s2 = list.get(i);
                        int diff = (s1.charAt(0) - s2.charAt(0)+26)%26;
                        int j=1;
                        for (; j<key; j++) {
                            if ((s1.charAt(j)-s2.charAt(j)+26)%26!=diff) break;
                        }
                        if (j==key) {
                            cur.add(s2);
                        }
                    }
                    res.add(cur);
                    list.removeAll(cur);
                }
            }
        }
        return res;
    }

    public static void main(String... args) {
        List<List<String>> lists = GroupShiftedStrings.groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "ac", "ba", "a", "z"});
        for (List<String> list : lists) {
            list.stream().forEach(o-> System.out.print(o + ", "));
            System.out.println();
        }
    }
}
