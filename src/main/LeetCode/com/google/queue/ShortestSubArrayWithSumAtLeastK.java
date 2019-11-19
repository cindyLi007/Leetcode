package com.google.queue;

import java.util.ArrayDeque;
import java.util.Deque;

// leetcode 862
public class ShortestSubArrayWithSumAtLeastK {
  // Time: O(N)
  public int shortestSubarray(int[] A, int K) {
    int N = A.length;

    // first creata a prefix sum Array
    int[] B = new int[N+1];
    for (int i=0; i<N; i++) {
      // B[i] denotes the sum [0, i-1], B[j]-B[i] is the sum [i, j-1];
      B[i+1] = B[i] + A[i];
    }

    // since there is negative number, we could not guarantee B[i+1] > B[i]
    Deque<Integer> deque = new ArrayDeque();
    deque.offer(0);
    int res = Integer.MAX_VALUE;

    for (int i=1; i<=N; i++) {
      // this 1st while part is to use B[i] as 被减数 in B[i]-B[j]中
      while (!deque.isEmpty() && B[i]-B[deque.peekFirst()] >= K)
        // the reason we poll first out is current i is most left index close to first entry in dequeu, even later index can satisfy the condition,
        // the length must greater than i - deque.peekFirst(), so we need not keep deque first
        res = Math.min(res, i - deque.pollFirst());

      while (!deque.isEmpty() && B[i] <= B[deque.peekLast()])
        // all entries in the deque can only be the deduct part (in B[i] - B[j], B[j] part),
        // so if we find a more close to right part which <= top of dequeu, that means we can make a shorter subarray which satisfy <=K condition
        // for later B[i], the 2nd while part is like stack
        deque.pollLast();

      deque.addLast(i);
    }
    return res > N ? -1 : res;
  }
}
