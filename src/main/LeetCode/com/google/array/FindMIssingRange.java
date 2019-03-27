package com.google.array;

import java.util.ArrayList;
import java.util.List;

public class FindMIssingRange {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums.length==0) {
            String str = lower==upper ? lower+"" : lower + "->" + upper;
            res.add(str);
            return res;
        }
        if (nums[0]>lower) {
            String str = nums[0]-lower==1 ? lower+"" : lower + "->" + (nums[0]-1);
            res.add(str);
        }
        int i=1;
        for (; i<nums.length; i++) {
            if (nums[i]-1>nums[i-1]) {
                String str = nums[i]-nums[i-1]==2 ? nums[i]-1+"" : nums[i-1]+1 + "->" + (nums[i]-1);
                res.add(str);
            }
        }
        if (upper > nums[i-1]) {
            String str = upper - nums[i-1] == 1 ? upper+"" : nums[i-1]+1 + "->" + upper;
            res.add(str);
        }
        return res;
    }
}
