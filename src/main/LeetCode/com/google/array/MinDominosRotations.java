package com.google.array;

/**
 * 1007. Minimum Domino Rotations For Equal Row
 * Input: A = [2,1,2,4,2,2],
 *        B = [5,2,6,2,3,2]
 * Output: 2
 * Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.
 */
public class MinDominosRotations {
    // Time: O(N)
    public static int minDominoRotations(int[] A, int[] B) {
        // we want to make all vals in A are same or all vals in B are same, that means the final val must appear in any entry
        // either in A or in B or in both, which means the final val must be from A[0] and B[0], check whether for each
        // following entry, there is the val appears in A[i] or B[i]
        int v = A[0];
        // a means how many times changes in A, b means how many times changes in B
        for (int i=0, a=0, b=0; i<A.length && (A[i]==v || B[i]==v); i++) {
            if (A[i]!=v) a++;
            if (B[i]!=v) b++;
            // if we find A[0] can be the final val, we need NOT to check B[0], that is because either B[0] is not the final val
            // or B[0] can be the final val, then must have same times for change
            // for ex. A is [2, 5, 2, 5, 5]
            //         B is [5, 2, 5, 2, 2]
            // first we choose A[0], val is 2, a is 3, b is 2, min time is 2;
            // if we choose B[0], val is 5, a is 2, b is 3, min time is also 2;
            if (i==A.length-1) return Math.min(a, b);
        }
        v = B[0];
        for (int i=0, a=0, b=0; i<A.length && (A[i]==v || B[i]==v); i++) {
            if (A[i]!=v) a++;
            if (B[i]!=v) b++;
            if (i==A.length-1) return Math.min(a, b);
        }
        return -1;
    }

    public static void main(String[] args) {
//        int minRotation = minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2});
//        int minRotation = minDominoRotations(new int[]{3, 5, 1, 2, 3}, new int[]{3, 6, 3, 3, 4});
        int minRotation = minDominoRotations(new int[]{1, 2, 3, 4, 6}, new int[]{6, 6, 6, 6, 5});
        System.out.println(minRotation);
    }
}
