package com.google.array;

public class NonDecresingArray {
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
