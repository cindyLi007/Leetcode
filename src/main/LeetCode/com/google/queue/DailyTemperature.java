package com.google.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days
 * you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 * Refer EPI 8.9
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 *
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100]
 */
public class DailyTemperature {
    // keep 2 Deques, one is strictly non-increaing temperature, called it temp, one deque is the index of the elem in the
    // Deque temp. 2 Deques should one-to-one corresponding
    public int[] dailyTemperatures(int[] T) {
        int N = T.length;
        int[] res = new int[N];
        Deque<Integer> temp = new ArrayDeque<>();
        Deque<Integer> index = new ArrayDeque<>();
        for (int i=0; i<N; i++) {
            int cur = T[i];
            // while current temp is warmer than previous daily temp, it will remove prev daily temp from the end of the deque
            // until the deque is empty or it encounter an equal-or-warm daily temp
            while (!temp.isEmpty() && temp.peekLast() < cur) {
                temp.removeLast();
                int idx = index.removeLast();
                res[idx]=i-idx;
            }
            temp.addLast(cur);
            index.addLast(i);
        }
        return res;
    }
}
