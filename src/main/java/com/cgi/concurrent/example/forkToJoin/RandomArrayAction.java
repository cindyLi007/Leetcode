package com.cgi.concurrent.example.forkToJoin;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by ychang on 8/5/2016.
 */
public class RandomArrayAction extends RecursiveAction {

  private final int threashold;
  private final int[] myArray;
  private int start;
  private int end;

  public RandomArrayAction(int start, int end, int threashold, int[] myArray) {
    this.start = start;
    this.end = end;
    this.threashold = threashold;
    this.myArray = myArray;
  }

  @Override
  protected void compute() {
    if (end - start < threashold) {
      for (int i = start; i <= end; i++) {
        myArray[i] = ThreadLocalRandom.current().nextInt();
      }
    } else {
      int midway = (end - start) / 2 + start;
      RandomArrayAction r1 = new RandomArrayAction(start, midway, threashold, myArray);
      RandomArrayAction r2 = new RandomArrayAction(midway + 1, end, threashold, myArray);
      invokeAll(r1, r2);
    }
  }
}
