package interview.uber.phone.interview;

/* 2019/07/30
Given a sorted array and a target number, return the number of target number in the array; If not contain, return 0.
 */
public class NumberOfTarget {
    // Time average is O(lgN), Space: O(lgN) related to code stack call
    // iteration do the binary search, worst cas is O(1)
    // binary search, if the mid == target, we will binary search in left and right, O(lgN)
    public int findTarget_recursive(int[] A, int t) {
        if (A==null || A.length==0)
            return 0;
        int N=A.length, l=0, r=N-1;
        return findHelper(A, t, l, r);
    }

    // Time: O(lgN), Space: O(lgN) -> O(1)
    private int findHelper(int[] A, int t, int l, int r) {
        if (l>r) return 0;
        if (t==A[l] && t==A[r])
            return r-l+1;
        int m = l + (r-l)/2;
        int v = A[m];
        if (v < t)
            return findHelper(A, t, m+1, r);
        if (v > t)
            return findHelper(A, t, l, m-1);
        return 1 + findHelper(A, t, m+1, r) + findHelper(A, t, l, m-1);
    }

    public int findTarget(int[] A, int target) {
        if (A == null || A.length == 0) return 0;
        int N = A.length, l = 0, h = N - 1;
        int res = 0;

        while (l < h) {
            int m = l + (h - l) / 2;
            if (A[m] > target) h = m - 1;
            else if (A[m] < target) h = l + 1;
            else { // A[m]==target
                // left side
                h = m - 1;
                while (l <= h) {
                    int lm = l + (h - l) / 2;
                    if (A[lm] == target) {
                        res += h - lm + 1;
                        h = lm - 1;
                    } else { // A[lm]<target
                        l = lm + 1;
                    }
                }
                // right side
                l = m + 1;
                while (l <= h) {
                    int rm = l + (h - l) / 2;
                    if (A[rm] == target) {
                        res += rm - l + 1;
                        l = rm + 1;
                    } else { // A[rm]>target
                        h = rm - 1;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        NumberOfTarget s = new NumberOfTarget();
        int res_1 = s.findTarget_recursive(new int[]{1, 4, 4, 4, 4, 4, 5, 6, 9, 10}, 4);
        int res_2 = s.findTarget_recursive(new int[]{1, 4, 4, 4, 4, 4, 5, 6, 9, 10}, 4);
        System.out.println(res_1 + "  " + res_2);
    }
}
