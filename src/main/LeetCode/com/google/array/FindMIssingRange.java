package com.google.array;

import java.util.ArrayList;
import java.util.List;

public class FindMIssingRange {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        if (nums.length == 0) {
            res.add(generate(lower, upper));
            return res;
        }
        int prev = lower - 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > prev + 1) {
                res.add(generate(prev + 1, num - 1));
            }
            prev = num;
            if (num >= upper) break;
        }

        if (prev < upper) res.add(generate(prev + 1, upper));

        return res;
    }

    private String generate(int start, int end) {
        StringBuilder sb = new StringBuilder();
        sb.append(start);
        if (start != end) {
            sb.append("->").append(end);
        }

        return sb.toString();
    }

    public static void main(String... args) {
        FindMIssingRange findMIssingRange = new FindMIssingRange();
        List<String> missingRanges = findMIssingRange.findMissingRanges(
                new int[]{-2147483648,2147483647},
        -2147483648,
        2147483647);
    }
}
