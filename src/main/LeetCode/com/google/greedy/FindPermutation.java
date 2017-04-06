package com.google.greedy;

/**
 * Created by ychang on 3/29/2017.
 * By now, you are given a secret signature consisting of character 'D' and 'I'. 'D' represents a decreasing relationship
 * between two numbers, 'I' represents an increasing relationship between two numbers. And our secret signature was
 * constructed by a special integer array, which contains uniquely all the different number from 1 to n (n is the length
 * of the secret signature plus 1). For example, the secret signature "DI" can be constructed by array [2,1,3] or [3,1,2],
 * but won't be constructed by array [3,2,4] or [2,1,3,4], which are both illegal constructing special string that can't
 * represent the "DI" secret signature.
 * On the other hand, now your job is to find the lexicographically smallest permutation of [1, 2, ... n] could refer to
 * the given secret signature in the input.
 */
public class FindPermutation {
  public int[] findPermutation(String s) {
    int len = s.length();
    int[] res = new int[len + 1];
    /**
     * first build an array in sorted order
     */
    for (int i = 1; i<=res.length; i++) {
      res[i - 1] = i;
    }
    /**
     * from String start to end, if we find "D" stream, we need reverse that part array.
     */
    for (int i = 0; i<len; i++) {
      int j = i;
      while (j<len && s.charAt(j)=='D') {
        j++;
      }
      /**
       * this is important to set i to the next "I". otherwise i will still begin from an already-reversed "D"
       */
      int next = j;
      while (j>i) {
        int temp = res[i];
        res[i++] = res[j];
        res[j--] = temp;
      }
      i = next;
    }
    return res;
  }
}
