package interview.uber.phone.interview;

/* 2019/07/30
 * Given a sorted array and a target number, return the number of target number in the array; If not contain, return 0.
 */
public class NumberOfTarget {
  // Time average is O(lgN), Space: O(lgN) related to code stack call
  // iteration do the binary search
  // binary search, if the mid == target, we will binary search in left and right, O(lgN)
  public int findTarget_recursive(int[] A, int t) {
    if (A == null || A.length == 0)
      return 0;
    int N = A.length, l = 0, r = N - 1;
    return findHelper(A, t, l, r);
  }

  // Time: O(lgN), Space: O(lgN) -> O(1)
  private int findHelper(int[] A, int t, int l, int r) {
    if (l > r) return 0;
    // 因为加了这行code 可以保证O(lgN), 因为可以跳过一些都等于target的items
    if (t == A[l] && t == A[r])
      return r - l + 1;
    int m = l + (r - l) / 2;
    int v = A[m];
    if (v < t)
      return findHelper(A, t, m + 1, r);
    if (v > t)
      return findHelper(A, t, l, m - 1);
    return 1 + findHelper(A, t, m + 1, r) + findHelper(A, t, l, m - 1);
  }

  public int findTarget(int[] A, int target) {
    if (A == null || A.length == 0) return 0;
    int N = A.length, l = 0, h = N - 1;
    int res = 0;

    // 我们要找一个区间 [l, h] 在这个区间里的所有数都满足A[i]==target
    while (l <= h) {
      if (A[l] == target && A[h] == target) return h - l + 1;
      int m = l + (h - l) / 2;
      if (A[m] > target) h = m - 1;
      else if (A[m] < target) l = m + 1;
      else { // A[m]==target
        // left side, 找到第一个i which A[i]==target in range [l, m-1]
        int right = m, left = l;
        while (left != right) {
          int mid = left + (right - left) / 2;
          if (A[mid] < target) left = mid + 1;
          else right = mid - 1;
        }
        int le = left; // left is the first i which A[i]==target in range [l, m-1]
        // right side 找到第一个i which A[i]>target
        left = m + 1;
        right = h;
        while (left <= right) {
          int mid = left + (right - left) / 2;
          if (A[mid] > target) right = mid - 1;
          else left = mid + 1;
        }
        int ri = left; // left is the first i which A[i] > target
        return ri - le;
      }
    }
    return res;
  }

  public static void main(String args[]) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    NumberOfTarget s = new NumberOfTarget();
    int res_1 = s.findTarget_recursive(new int[]{1, 4, 4, 4, 4, 5, 5, 6, 9, 10}, 4);
    int res_2 = s.findTarget(new int[]{1, 4, 4, 4, 4, 5, 5, 6, 9, 10}, 4);
    System.out.println(res_1 + "  " + res_2);
  }
}
