package temp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ychang on 10/3/2017.
 */
class Solution1 {
  public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    int N = nums.length, max = 0;
    // left[i] is the starting index for the left interval in range [0, i];
    // right[i] is the starting index for the right interval in range [i, n-1];
    // k<=i<=n-2k mid interval is [i, i+k-1]
    int[] sum = new int[N+1], left = new int[N], right = new int[N];

    // for quick get an interval sum, first calculate all sum of range [0, i], 0<=i<N
    for (int i=1; i<=N; i++) {
      sum[i] = sum[i-1]+nums[i-1];
    }

    // find left maxSum idx, from [0, len-2k]
    for (int i=k, curSum=sum[k]; i<N; i++) {
      if (curSum < sum[i+1]-sum[i+1-k]) {
        left[i]=i+1-k;
        curSum = sum[i+1]-sum[i+1-k];
      }
      else left[i]=left[i-1];
    }

    // find right maxSum idx, from [len-1, 0+2k]
    right[N-k]=N-k;
    for (int i=N-k-1, curSum=sum[N]-sum[N-k]; i>=0; i--) {
      if (curSum <= sum[i+k]-sum[i]) {
        right[i]=i;
        curSum = sum[i+k]-sum[i];
      }
      else right[i]=right[i+1];
    }

    // find mid maxSum idx, from [k, len-k]
    int[] res = new int[3];
    for (int i=k; i<=N-2*k; i++) {
      int l=left[i-1], r = right[i+k];
      int tot = (sum[i+k]-sum[i]) + (sum[l+k]-sum[l]) + (sum[r+k]-sum[r]);
      if (tot > max) {
        max = tot;
        res[0]=l; res[2]=r; res[1]=i;
      }
    }
    return res;
  }

  public static void main(String... args) {
    int[] array = {1, 2, 1, 2, 6, 7, 5, 1};
    int[] res = maxSumOfThreeSubarrays(array, 2);
    // how to sort an existing map
    Map<Integer, Integer> map = new HashMap<>();
    ArrayList arrayList = new ArrayList(map.keySet());
    Collections.sort(arrayList);
  }
}
