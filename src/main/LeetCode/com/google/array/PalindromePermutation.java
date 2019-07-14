package com.google.array;

import com.google.dp.PalindromePatitionII;

import java.util.*;

public class PalindromePermutation {
    // Time: O(N*N!), Space: O(N)
    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count=0;
        char ch='a';
        for (Character c : map.keySet()) {
            Integer i = map.get(c);
            if (i%2==1) {
                if (count==1) return Collections.emptyList();
                count++;
                ch = c;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : map.keySet()) {
            if (ch==c && count==1 && map.get(ch)==1) continue;
            for (int i=0; i<map.get(c)/2; i++) sb.append(c);
        }
        List<String> res = new ArrayList<>();
        List<String> left = permute(sb.toString());
        for (String l : left) {
            String r = new StringBuilder(l).reverse().toString();
            if (count==0) res.add(l+r);
            else res.add(l+ch+r);
        }
        return res;
    }

    private List<String> permute(String s) {
        int N = s.length();
        char[] ch = s.toCharArray();
        boolean[] marked = new boolean[N];
        List<String> res = new ArrayList<>();
        permute(ch, marked, "", res);
        return res;
    }

    private void permute(char[] ch, boolean[] marked, String s, List<String> res) {
        if (s.length() == ch.length) res.add(s);
        else {
            for (int i=0; i<ch.length; i++) {
                if (!marked[i]) {
                    marked[i]=true;
                    permute(ch, marked, s+ch[i], res);
                    marked[i]=false;
                    while (i<ch.length-1 && ch[i]==ch[i+1]) i++;
                }
            }
        }
    }

    public static void main(String... args) {
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        List<String> res = palindromePermutation.generatePalindromes("aab");
        res.stream().forEach(System.out::println);
    }
}
