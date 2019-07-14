package com.google.array;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumDisappeared {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx]>0) nums[idx] = -nums[idx];
        }

        for (int i=0; i<nums.length; i++) {
            if (nums[i]>0) res.add(i+1);
        }
        return res;
    }

    public static void main(String... args) {
        List<Integer> res = findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }
}
