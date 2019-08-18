package com.google.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    // Time: O(N * K)
    PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> right = new PriorityQueue<>();

    public double[] medianSlidingWindow(int[] nums, int k) {

        int N = nums.length, i=0;
        // always keep left.size>=right.size
        double[] res = new double[N-k+1];
        for (; i<k; i++) {
            add(nums[i]);
        }

        for (; i<=N; i++) {
            if (left.size()==right.size()) {
                // must do this way instead of (left.peek() + right.peek()) * 0.5 to prevent overflow
                res[i-k] = 0.5 * left.peek() + 0.5 * right.peek();
            } else {
                res[i-k] = left.peek().doubleValue();
            }
            if (i==N) break;
            if (right.size() ==0 || nums[i-k]<right.peek()) left.remove(nums[i-k]);
            else right.remove(nums[i-k]);
            add(nums[i]);
        }
        return res;
    }

    private void add(int v) {
        // must first arbitary put in one heap, then poll that heap top to the other heap to keep the order
        right.offer(v);
        left.offer(right.poll());
        if (left.size()<right.size()) left.offer(right.poll());
        else if (right.size()<left.size()-1) right.offer(left.poll());
    }
}
