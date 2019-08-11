package com.google.graph;

import java.util.*;

public class FindCheapestFlight {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // suppose we already have the Map<souce, List of target> graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] f : flights) {
            int s = f[0], t = f[1], p =f[2];
            graph.computeIfAbsent(s, k->new ArrayList()).add(new int[]{t, p});
        }
        // this heap is keep all [price, vetex, stop] pair in price ascending order
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> o1[0]-o2[0]);
        pq.offer(new int[]{0, src, -1});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[1]==dst) return cur[0];
            List<int[]> neighbors = graph.get(cur[1]);
            if (neighbors!=null && neighbors.size()>0) {
                for (int[] neighbor : neighbors) {
                    if (cur[2]+1<=K)
                        pq.offer(new int[]{cur[0]+neighbor[1], neighbor[0], cur[2]+1});
                }
            }
        }
        return -1;
    }

    public static void main(String... args) {
        //n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
        //src = 0, dst = 2, k = 1
        int[][] edges = new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int cheapestPrice = findCheapestPrice(3, edges, 0, 2, 0);
        System.out.println(cheapestPrice);
    }
}
