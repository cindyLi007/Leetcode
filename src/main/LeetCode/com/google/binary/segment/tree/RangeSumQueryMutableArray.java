package com.google.binary.segment.tree;

/**
 * Created by ychang on 6/13/2017.
 * this can beat 61%
 */
public class RangeSumQueryMutableArray {
  int[] tree; // an array represent segment tree
  final int N;

  public RangeSumQueryMutableArray(int[] nums) {
    N=nums.length;
    tree=new int[2*N];
    // build all leaf nodes
    for (int i=N, j=0; i<2*N; i++, j++) {
      tree[i]=nums[j];
    }
    // based on leaf node, build all intermediate nodes, note tree[1] is the root node
    for (int i=N-1; i>0; i--) {
      tree[i]=tree[2*i]+tree[2*i+1];
    }
  }

  public void update(int i, int val) {
    // convert i to idx in tree
    int idx=i+N;
    int diff=val-tree[idx];
    while (idx>0) {
      tree[idx]+=diff;
      idx/=2;
    }
  }

  public int sumRange(int i, int j) {
    // convert i, j to idx in tree
    int idx1=i+N, idx2=j+N;
    int sum=0;
    while (idx1<=idx2) {
      if (idx1%2!=0) { // left boundary is NOT left node, we could not use Parent sum
        sum+=tree[idx1];
        idx1++; // this will make next loop idx point to its parent's right neighbor
      }
      if (idx2%2==0) { // right boundary is NOT right node, we could not use Parent sum
        sum+=tree[idx2];
        idx2--; // this will make next loop idx point to its parent's left neighbor
      }
      idx1/=2;
      idx2/=2;
    }
    return sum;
  }
}
