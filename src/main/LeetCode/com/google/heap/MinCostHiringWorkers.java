package com.google.heap;

import java.util.*;

public class MinCostHiringWorkers {
    // Time: O(NlgN), space: O(N)
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        Worker[] list = new Worker[wage.length];
        for (int i=0; i<wage.length; i++) {
            list[i] = new Worker(quality[i], wage[i]);
        }
        // O(n*lgN)
        // NOTICE: Could not use o1.ratio - o2.ratio, because ratio is double, so the result of o1.ratio - o2.ratio is double, but comapre must return int
        Arrays.sort(list, Comparator.comparingDouble(o -> o.ratio));
        // a heap size of K, whenever size > K, remove the largest Quality which is the head of this heap, the reason to
        // remove the largest quality is all workers in the paid group should be paid in the same ratio and
        // ratio = wage / quality, which means for a fixed ratio, the larger quality, the larger wage
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        double res = Double.MAX_VALUE;
        int sumQ = 0;
        // O(n*lgK)
        for (Worker worker : list) {
            if (pq.size()==K && worker.quality >= pq.peek()) continue;
            pq.offer(worker.quality);
            sumQ += worker.quality;
            // remove the largest Quality
            if (pq.size()>K) sumQ -= pq.poll();
            if (pq.size()==K) res = Math.min(res, sumQ * worker.ratio);
        }
        return res;
    }

    class Worker {
        int quality;
        double ratio; // wage/quality

        Worker(int q, int w) {
            quality = q;
            ratio = (double) w / (double) q;
        }
    }
}
