package com.google.union.find;

import java.util.HashMap;

/**
 * Created by ychang on 1/13/2017.
 * No need to create a separate class UnionFind
 */
public class LongestConsecutiveSequence {
  int[] uf;
  int[] sz;
  int res = 0;

  public int longestConsecutive(int[] nums) {
    if (nums.length>0) res=1;
    uf = new int[nums.length];
    sz = new int[nums.length];
    /** this map <value, index> is to help find left and right nodes, since union find always use index as component Id,
       we need store index */
    HashMap<Integer, Integer> map = new HashMap();

    for (int i=0; i<nums.length; i++) {
      int n=nums[i];
      uf[i]=i;
      sz[i]=1;
      if (!map.containsKey(n)){
        map.put(n, i);
        if (map.containsKey(n-1))
          connect(i, map.get(n-1));
        if (map.containsKey(n+1))
          connect(i, map.get(n+1));
      }
    }
    return res;
  }

  private void connect(int x, int y){
    int p = find(x, uf);
    int q = find(y, uf);
    if (p!=q) {
      int small = sz[q]<sz[p] ? q : p;
      int large = sz[q]<sz[p] ? p : q;
      uf[small] = large;
      // only need change the root node size
      sz[large] += sz[small];
      res = Math.max(res, sz[large]);
    }
  }

  public int find(int x, int[] uf){
    while (uf[x]!=x) {
      uf[x]=uf[uf[x]];
      x=uf[x];
    }
    return x;
  }
}
