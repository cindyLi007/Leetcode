package com.google.binary.search;

import java.util.LinkedList;
import java.util.List;

/**Given a sorted array, two integers k and x, find the k closest elements to x in the array.
 * The result should also be sorted in ascending order. If there is a tie, the smaller elements are
 * always preferred.

        Example 1:
        Input: [1,2,3,4,5], k=4, x=3
        Output: [1,2,3,4]
        Example 2:
        Input: [1,2,3,4,5], k=4, x=-1
        Output: [1,2,3,4]
*/
// Time: O(LgN + K), Space: O(K)
public class FindKCloesestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // since arr is a sorted, should use binary search to find the closest elem
        int start = 0, end = arr.length - 1;
        int closestIdx = -1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == x) {
                closestIdx = mid;
                break;
            } else if (arr[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (closestIdx == -1) closestIdx = start;

        // from the closest elem, in 2 directions to find k elem
        int count = 1, low = closestIdx - 1, high = closestIdx + 1;
        List<Integer> res = new LinkedList();
        res.add(arr[closestIdx]);
        while (count < k && low >= 0 && high < arr.length) {
            if (Math.abs(x - arr[low]) <= Math.abs(arr[high] - x)) {
                res.add(0, arr[low--]);
            } else {
                res.add(arr[high++]);
            }
            count++;
        }
        while (count < k) {
            if (low >= 0) res.add(0, arr[low--]);
            else res.add(arr[high++]);
            count++;
        }
        return res;

    }
}
