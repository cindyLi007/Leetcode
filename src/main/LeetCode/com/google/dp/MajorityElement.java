package com.google.dp;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int res=nums[0], count=0;

        for (int n : nums) {
            if (n==res) {
                count++;
            } else {
                count--;
            }
            if (count==0) {
                res=n;
            }
        }

        return res;
    }
}
