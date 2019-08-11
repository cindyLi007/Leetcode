package com.google.array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// 358. Rearrange String k Distance Apart
public class RearrangeStringKDistanceApart {
    public String rearrangeString(String s, int k) {
        if (k <= 1) return s;
        StringBuilder sb = new StringBuilder();
        int[] map = new int[26];
        // O(N)
        for (char c : s.toCharArray()) map[c - 'a']++;

        // must compare both count and char, because we need stick the relative order of chars. for ex. "aabbcc", k=3. we do not compare char,
        // we can not guarantee every char is 3, we maybe can get "acbabc"
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->
                o2[1] - o1[1] == 0 ? o1[0] - o2[0] : o2[1] - o1[1]);
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) pq.offer(new int[]{i, map[i]});
        }
        // Time: O(N * lg26) = O(N)
        while (!pq.isEmpty()) {
            // must use a new list to record just add-to-string chars, because if we directly put it back to PQ, it can still be the top of the PQ, will be poll again.
            List<int[]> list = new ArrayList();
            int n = k;
            while (n > 0 && !pq.isEmpty()) {
                int[] cur = pq.poll();
                sb.append((char) (cur[0] + 'a'));
                if (--cur[1] > 0) list.add(cur);
                n--;
            }
            // when n>0 && list.size() == 0 that means we run out all chars, we are done
            if (n > 0 && list.size() > 0) return "";
            // must use addAll to not lose other chars which not added to string this round.
            pq.addAll(list);
        }

        return sb.toString();
    }

    /* this is wrong way.
    public String rearrangeString_1(String s, int k) {
        int[] map = new int[26];
        // O(N)
        for (char c : s.toCharArray()) map[c - 'a']++;
        int max = 0, idx = -1;
        for (int i=0; i<26; i++) {
            if (map[i]>max) {
                max = map[i]; idx=i;
            }
        }
        int N = s.length();
        if ((max-1)*k + 1> N) return "";
        char[] ch = new char[N];
        for (int i=0; i<N && map[idx]>0; i+=k) {
            ch[i]=(char)(idx + 'a');
            map[idx]--;
        }
        for (int i=0; i<26; i++) {
            if (map[i]!=0) insert((char)(i+'a'), ch, map[i], k);
        }
        return String.valueOf(ch);
    }

    private void insert(char c, char[] ch, int times, int k) {
        int N=ch.length;
        int j=0;
        for (int i=1; i<N && times-->0; i=j+k) {
            j=i;
            while (j<N && Character.isLetter(ch[j])) {
                if (ch[j]==c) j+=k;
                else j++;
            }
            if (j<N) ch[j]=c;
        }
    }*/

    public static void main(String... args) {
        String s = "aa";
        RearrangeStringKDistanceApart r = new RearrangeStringKDistanceApart();
        System.out.println(r.rearrangeString(s, 2));
    }
}
