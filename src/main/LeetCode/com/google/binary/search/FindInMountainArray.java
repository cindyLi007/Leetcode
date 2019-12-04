package com.google.binary.search;

// LC 1095
public class FindInMountainArray {
  public int findInMountainArray(int target, MountainArray mountainArr) {
    return helper(target, mountainArr, 0, mountainArr.length() - 1);
  }

  // Time: average O(lgN) worst O(N)
  private int helper(int t, MountainArray mountainArr, int l, int h) {
    // base case
    if (l == h) return mountainArr.get(l) == t ? l : -1;
    if (l + 1 == h) {
      if (mountainArr.get(l) == t) return l;
      return mountainArr.get(h) == t ? h : -1;
    }

    // recursive, notice since from base case we guaranteen h >= l+2, prev and next value must exist
    int m = l + (h - l) / 2;
    int v = mountainArr.get(m), prev = mountainArr.get(m - 1), next = mountainArr.get(m + 1);
    if (prev < v) {
      // in Mountain left side or m is the peak
      if (v == t) return m;
      if (v > t) {
        int left = helper(t, mountainArr, l, m - 1);
        return left == -1 ? helper(t, mountainArr, m + 1, h) : left;
      }
      if (v > next) return -1;
      else return helper(t, mountainArr, m + 1, h);
    }
    // in Mountain right side, in this case, we definately need check whether there is match in left side
    else {
      int left = helper(t, mountainArr, l, m - 1);
      if (left != -1) return left;
      return v == t ? m : v > t ? helper(t, mountainArr, m + 1, h) : -1;
    }
  }
}

interface MountainArray {
  public int get(int index);

  public int length();
}