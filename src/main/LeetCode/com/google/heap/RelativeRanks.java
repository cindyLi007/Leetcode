package com.google.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be
 * awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 */
// Time: O(NlgN), Space: O(N)
public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        int N = nums.length;
        String[] res = new String[N];
        int[] copy = Arrays.copyOf(nums, N);
        // Time: O(N*lgN)
        Arrays.sort(copy);
        // Space: O(N);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<N; i++) {
            map.put(nums[i], i);
        }
        int count=1;
        for (int n : copy) {
            String val;
            switch (count) {
                case 1 : val = "Gold Medal"; break;
                case 2 : val = "Silver Medal"; break;
                case 3 : val = "Bronze Medal"; break;
                default : val = String.valueOf(count);
            }
            res[map.get(n)] = val;
            count++;
        }
        return res;
    }
}
