package com.google.bfs.dfs.dfs;

import java.util.LinkedList;
import java.util.List;

import com.google.stack.NestedInteger;

/**
 * Created by ychang on 2/21/2017.
 */
public class NestedListDepthSumII {
  public int depthSumInverse_recursive(List<NestedInteger> nestedList) {
    // first find max depth
    int max = depth(nestedList, 0);
    // second pass max, from upper to lower, decrease depth
    return depthSum(nestedList, max);
  }

  private int depthSum(List<NestedInteger> list, int depth) {
    int res=0;
    for (NestedInteger n : list) {
      res+=n.isInteger() ? n.getInteger()*depth : depthSum(n.getList(), depth-1);
    }
    return res;
  }

  private int depth(List<NestedInteger> list, int depth) {
    int max=0;
    for (NestedInteger n : list){
      max=Math.max(max, n.isInteger() ? depth+1 : depth(n.getList(), depth+1));
    }
    return max;
  }

  /**
   * Instead of multiplying by depth, add integers multiple times (by going level by level and adding the unweighted sum
   * to the weighted sum after each level).
   */
  public int depthSumInverse_iterate(List<NestedInteger> nestedList) {
    int unweighted=0, weighted=0;
    while (!nestedList.isEmpty()) {
      List<NestedInteger> nextLevel = new LinkedList();
      for (NestedInteger ni : nestedList) {
        if (ni.isInteger()){
          /**
           * unweighted should NOT be clear, for example [1, [4, [6]]], is like 1 + (1+4) + (1+4+6) which 1, (1+4), (1+4+6) is
           * each unweighted value
           */
          unweighted+=ni.getInteger();
        } else {
          nextLevel.addAll(ni.getList());
        }
      }
      nestedList=nextLevel;
      // after each level, weighted will add upper levels int
      weighted+=unweighted;
    }
    return weighted;
  }
}
