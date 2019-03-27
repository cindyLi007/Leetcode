package com.google.dp;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    // For any array, there is at most 2 elements where freq > N/3, so we only need keep 2 majority element
    // Time: O(n), Space: O(1)
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int count_a=0, count_b=0, A=0, B=0;
        for (int n: nums) {
            if (n==A) {
                count_a++;
            } else if (n==B) {
                count_b++;
            } else if (count_a==0) {
                A=n;
                count_a=1;
            } else if (count_b==0) {
                B=n;
                count_b=1;
            } else {
                count_a--;
                count_b--;
            }
        }

        count_a=0;
        count_b=0;
        for (int n : nums) {
            if (n==A) count_a++;
            else if (n==B) count_b++;
        }

        if (count_a>nums.length/3) res.add(A);
        if (count_b>nums.length/3) res.add(B);

        return res;
    }
}
