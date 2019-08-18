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
    // Backward loop the array, whenever current T >= stack top, no need to keep the item in stack, we always insert current T to
    // stack because we don't know whether prev day [(i-1)th day] is less than current T
    public int[] dailyTemperatures(int[] T) {
        int N = T.length;
        int[] res = new int[N];
        res[N-1]=0;
        // keep descending list in stack, but we actually store the index
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(N-1);
        for (int i=N-2; i>=0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop();
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}
