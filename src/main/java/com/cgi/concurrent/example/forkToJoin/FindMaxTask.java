package com.cgi.concurrent.example.forkToJoin;

import static java.lang.Math.max;

import java.util.concurrent.RecursiveTask;

/**
 * Created by ychang on 8/5/2016.
 */
public class FindMaxTask extends RecursiveTask<Integer> {
  private final int threadhold;
  private final int[] myArray;
  private int start;
  private int end;

  public FindMaxTask(int start, int end, int threadhold, int[] myArray) {
    this.start = start;
    this.end = end;
    this.threadhold = threadhold;
    this.myArray = myArray;
  }

  @Override
  protected Integer compute() {
    if (start - end < threadhold) {
      int max = Integer.MIN_VALUE;
      for (int i = start; i <= end; i++) {
        if (myArray[i] > max) {
          max = myArray[i];
        }
      }
      return max;
    } else {
      int middle = (end - start)/2 + start;
      FindMaxTask findMaxTask1 = new FindMaxTask(start, middle, threadhold, myArray);
      findMaxTask1.fork();
      FindMaxTask findMaxTask2 = new FindMaxTask(middle + 1, end, threadhold, myArray);
      return max(findMaxTask2.compute(), findMaxTask1.join());
    }
  }
}
