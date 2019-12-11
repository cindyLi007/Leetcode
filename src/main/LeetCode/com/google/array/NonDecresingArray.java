package com.google.array;

public class NonDecresingArray {
    // Time: O(N), Space: O(1)
    public boolean checkPossibility_onePass(int[] nums) {
        int N = nums.length;
        if (N<=2) return true;
        boolean found = false;
        // min denotes before current's previous item, what is the max value
        int max = nums[0], min = Integer.MIN_VALUE;
        for (int i=1; i<N; i++) {
            if (nums[i] < max) {
                if (found) return false;
                found = true;
                // if (nums[i] <= min), that means we must change nums[i] to max+1;
                if (nums[i] <= min) max++;
                // we can change the nums[i-1] to lower value.
                else max = nums[i];
            } else {
                min = max;
                max = nums[i];
            }
        }
        return true;
    }

    public static boolean checkPossibility(int[] nums) {
        int count=0, N=nums.length, max=nums[0], min=nums[N-1];
        for (int i=0; i<N; i++) {
            if (nums[i]<max) {
                count++;
            } else {
                max = nums[i];
            }
        }
        if (count<=1)
            return true;
        count=0;
        for (int i=N-1; i>=0; i--) {
            if (nums[i]>min) {
                if (count==0) count++;
                else return false;
            } else {
                min = nums[i];
            }
        }
        return true;
    }

    public static void main(String... ars) {
        boolean shouldBeTrue = checkPossibility(new int[]{-1, 4, 2, 3});
        System.out.println("Should be True: " + shouldBeTrue);

        boolean shouldBeFalse = checkPossibility(new int[]{4, 2, 1});
        System.out.println("Should be False: " + shouldBeFalse);

        shouldBeFalse = checkPossibility(new int[]{3, 4, 2, 3});
        System.out.println("Should be False: " + shouldBeFalse);

        shouldBeTrue = checkPossibility(new int[]{2, 3, 4, 2, 4});
        System.out.println("Should be True: " + shouldBeTrue);

        shouldBeFalse = checkPossibility(new int[]{2, 3, 4, 2, 2});
        System.out.println("Should be False: " + shouldBeFalse);
    }
}
