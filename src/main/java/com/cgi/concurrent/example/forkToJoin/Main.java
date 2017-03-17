package com.cgi.concurrent.example.forkToJoin;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by ychang on 8/5/2016.
 */
public class Main {
  public static void main(String[] args) {
    int[] data = new int[1024*1024*128];

    ForkJoinPool forkJoinPool = new ForkJoinPool();
    RandomArrayAction action = new RandomArrayAction(0, data.length - 1, data.length/16, data);
    forkJoinPool.invoke(action);

    FindMaxTask task = new FindMaxTask(0, data.length - 1, data.length/16, data);
    Integer result = forkJoinPool.invoke(task);
    System.out.println("Max value found: " + result);
  }
}
