package com.google.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextElement {
    public static int[] nextGreaterElements(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];
        Arrays.fill(res, -1);
        for (int i = 0; i < N; i++) {
            int j = i + 1;
            for (; j < N; j++) {
                if (nums[j] > nums[i]) {
                    res[i] = nums[j];
                    break;
                }
            }
            if (j == N) {
                j = 0;
                while (j < i && nums[j] <= nums[i]) j++;
                if (j < i)
                    res[i] = nums[j];
            }
        }
        return res;
    }

    public static int[] nextGreaterElements_stack(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * N; i++) {
            int n = nums[i%N];
            while (!stack.isEmpty() && nums[stack.peek()] < n) {
                res[stack.pop()] = n;
            }
            // Only when i<N we push it into stack, stack is to store all index which have NOT been found a greater one
            if (i<N) {
                stack.push(i);
            }
        }
        return res;
    }

    public static void main(String... args) {
        int[] array = new int[]{1, 2, 3, 2, 1};
        Arrays.stream(nextGreaterElements_stack(array)).forEach(o-> System.out.print(o + ", "));
    }
}
