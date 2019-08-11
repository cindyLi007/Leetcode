package com.google.queue;

import java.util.*;

public class MedianSlidingWindow {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int N = nums.length, i=0;
        // always keep left.size>=right
        double[] res = new double[N-k+1];
        for (; i<k; i++) {
            if (left.size()==right.size()) left.add(nums[i]);
            else right.add(nums[i]);
        }

        for (; i<=N; i++) {
            if (left.size()==right.size()) {
                res[i-k] = 0.5 * (left.peek() + right.peek());
            } else {
                res[i-k] = left.peek() * 1.0;
            }
            if (i==N) break;
            right.add(nums[i]);
            if (nums[i-k]<right.peek()) left.remove(nums[i-k]);
            else right.remove(nums[i-k]);
            while (right.size()>left.size()) left.offer(right.poll());
        }
        return res;
    }

    public static void main(String... args) {
        MedianSlidingWindow window = new MedianSlidingWindow();
//        double[] res = window.medianSlidingWindow(new int[]{2147483647,2147483647},2);
        double[] res = window.medianSlidingWindow(new int[]{1, 2},1);
        Arrays.stream(res).forEach(o-> System.out.print(o + ", "));
    }
}
