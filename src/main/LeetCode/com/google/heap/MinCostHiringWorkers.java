package com.google.heap;

import java.util.*;

public class MinCostHiringWorkers {
    // Time: O(NlgN), space: O(N)
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        List<Worker> list = new ArrayList<>();
        for (int i=0; i<wage.length; i++) {
            list.add(new Worker(quality[i], wage[i]));
        }
        // O(n*lgN)
        Collections.sort(list, Comparator.comparingDouble(o -> o.ratio));
        // a heap size of K, whenever size > K, remove the largest Quality which is the head of this heap, the reason to
        // remove the largest is ratio = wage / quality, which means for a fixed ratio, the larger quality, the larger wage
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        double res = Double.MAX_VALUE;
        int sumQ = 0;
        // O(n*lgK)
        for (Worker worker : list) {
            pq.offer(worker.quality);
            sumQ += worker.quality;
            if (pq.size()>K) {
                // remove the largest Quality, even if the largest one is current worker, we stil use the current worker's
                // ratio, because WO current worker, we can have a better cost.
                Integer largestQuality = pq.poll();
                sumQ -= largestQuality;
            }
            if (pq.size()==K) {
                res = Math.min(res, sumQ * worker.ratio);
            }
        }
        return res;
    }

    class Worker {
        int quality, wage;
        double ratio; // wage/quality

        Worker(int q, int w) {
            quality = q;
            wage = w;
            ratio = (double) w / (double) q;
        }
    }
}
