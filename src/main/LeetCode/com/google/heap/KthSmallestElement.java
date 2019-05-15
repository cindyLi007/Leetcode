package com.google.heap;

import java.util.PriorityQueue;

public class KthSmallestElement {
    // Time: O(K*lgK), Space: O(K)
    public int kthSmallest(int[][] matrix, int k) {
        // bruce force: loop through all element in matrix and sorted, find the Kth
        int N=matrix.length;
        // We need matain a minHeap, each time find the head of the heap's next elem and put in PQ
        PriorityQueue<Item> pq = new PriorityQueue<>();
        // the reason we first put the lst row in PQ is IF we check both the right and lower val in the matrix for an item
        // in PQ, we will duplicate put some item in the PQ, so we first put 1st row in PQ and later only check lower val in matrix
        for (int i=0; i<N; i++) {
            pq.offer(new Item(matrix[0][i], 0, i));
        }
        int count=1;
        while (count <  k) {
            Item cur = pq.poll();
            int x = cur.x, y = cur.y;
            if (x<N-1) {
                pq.offer(new Item(matrix[x+1][y], x+1, y));
            }
            count++;
        }
        return pq.poll().val;
    }

    class Item implements Comparable<Item> {
        int val;
        int x, y;
        Item(int val, int x, int y) {
            this.val=val;
            this.x=x;
            this.y=y;
        }
        @Override
        public int compareTo(Item o) {
            return val - o.val;
        }
    }
}
