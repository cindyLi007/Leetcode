package com.google.array;

import java.util.*;

public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) map[c-'A']++;
        Arrays.sort(map);
        int max = map[25];
        int i=25, maxCount=0;
        while (i>=0 && map[i--]==max)
            maxCount++;
        return Math.max(tasks.length, (max-1)*(n+1) + maxCount);
    }

    public static int leastInterval_priorityQueue(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) map[c - 'A']++;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (int i=0; i<26; i++) {
            if (map[i]>0) pq.offer(map[i]);
        }
        int count=0;
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int k=n+1;
            while (k > 0 && !pq.isEmpty()) {
                Integer cnt = pq.poll();
                cnt--;
                temp.add(cnt);
                k--;
                count++;
            }
            for (Integer i : temp) {
                if (i>0) pq.offer(i);
            }
            if (pq.isEmpty()) break;
            count+=k;
        }
        return count;
    }

    public static void main(String... args) {
        int leastInterval = leastInterval_priorityQueue(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
        System.out.println(leastInterval);
    }
}
