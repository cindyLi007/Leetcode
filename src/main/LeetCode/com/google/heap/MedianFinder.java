package com.google.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    /** initialize your data structure here. */
    public MedianFinder() {
        left = new PriorityQueue<>(Comparator.reverseOrder());
        right = new PriorityQueue<>();
    }

    // Time: O(logN)
    public void addNum(int num) {
        left.offer(num);
        right.offer(left.poll());
        if (left.size() < right.size()) left.add(right.poll());
    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return 0.5 * (left.peek() + right.peek());
        }
        return left.peek().doubleValue();
    }

    public static void main(String... args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(2); pq.add(4); pq.add(1); pq.add(3);
        while (!pq.isEmpty())
            System.out.print(pq.poll() + " ");

        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
    }
}
