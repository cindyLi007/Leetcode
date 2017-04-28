package com.google.array;

/**
 * Created by ychang on 4/26/2017.
 */
public class FindCelebrity {
  public int findCelebrity(int n) {
    boolean[] normal = new boolean[n];
    for (int i=0; i<n; i++) {
      if (normal[i]) continue;
      int j=0;
      for (; j<n; j++) {
        if (j==i) continue;
        if (knows(j, i)) {
          normal[j]=true;
          if(knows(i, j)) break;
        }
        else break;
      }
      if (j==n) return i;
    }
    return -1;
  }

  public int findCelebrity_ON(int n) {
    int candidate=0;
    for (int i=1; i<n; i++) {
      if (knows(candidate, i)) candidate=i;
    }
    /** after 1st pass, we find a node X which has at least one node knows X and X knows no node bigger than it. It should
        be the only candidate, because all nodes bigger than X, X does not know it; all node smaller than X has at least
        outbound (knowing) edge
     */
    // this pass verify whether candidate is a celebrity
    for (int i=0; i<n; i++) {
      if (i!=candidate && (!knows(i, candidate) || knows(candidate, i))) return -1;
    }
    return candidate;
  }

  private boolean knows(int j, int i) {
    return false;
  }
}
