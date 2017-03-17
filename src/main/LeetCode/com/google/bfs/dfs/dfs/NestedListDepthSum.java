package com.google.bfs.dfs.dfs;

import java.util.List;

import com.google.stack.NestedInteger;

/**
 * Created by ychang on 2/21/2017.
 */
public class NestedListDepthSum {
  public int depthSum(List<NestedInteger> nestedList) {
    return depthSum(nestedList, 1);
  }

  private int depthSum(List<NestedInteger> list, int depth) {
    if (list.size()==0) return 0;
    int res=0;
    for (NestedInteger ni : list) {
      res += ni.isInteger() ? ni.getInteger()*depth : depthSum(ni.getList(), depth+1);
    }
    return res;

  }
}
