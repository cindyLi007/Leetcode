package com.google.segment.tree;

// Leetcode 327
public class CountRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; ++i)
            sums[i + 1] = sums[i] + nums[i];
        return countWhileMergeSort(sums, 0, n + 1, lower, upper);
    }

    private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) return 0;
        int mid = (start + end) / 2;
        // 当我们已经做完左边和右边的count以后 我们并不care它们内部的sum的顺序 我们只care左边的和右边这两个部分的sum的差值
        // 此时应该把它们排序 这样便于查找 像Amazon的面试题
        int count = countWhileMergeSort(sums, start, mid, lower, upper)
            + countWhileMergeSort(sums, mid, end, lower, upper);
        int j = mid, k = mid;
        // [low, m) and [m, high) has been sorted, now begin to merge them we need to find (sum[j] - sum[i]) in [lower, upper], j from right, i from left
        // for each i in left side, find the range of j which j1 is the first idx make (sum[j] - sum[i] >= lower); j2 is the first idx make (sum[j]-sum[i] > upper)
        long[] cache = new long[end - start];
        for (int i = start, r = 0; i < mid; ++i, ++r) {
            while (k < end && sums[k] - sums[i] < lower) k++;
            while (j < end && sums[j] - sums[i] <= upper) j++;
            count += j - k;
            // no need to reset k and j, that is becasue left half is sorted, next nums[i] must bigger than current nums[i]
        }
        j=start; k=mid;
        int r = 0;
        while (j<mid && k<end) {
            cache[r++] = (sums[j]<sums[k]) ? sums[j++] : sums[k++];
        }
        while (j<mid) cache[r++] = sums[j++];
        while (k<end) cache[r++] = sums[k++];
        System.arraycopy(cache, 0, sums, start, cache.length);
        return count;
    }

    public static void main(String... args) {
        CountRangeSum countRangeSum = new CountRangeSum();
        // int count = countRangeSum.countRangeSum(new int[]{0, 3, -3, 2, -1, 2}, 3, 5);
        int count = countRangeSum.countRangeSum(new int[]{-2, 5, -1}, -2, 2);
        System.out.println(count);
    }
}
