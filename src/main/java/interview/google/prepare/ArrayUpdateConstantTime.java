package interview.google.prepare;

import java.util.Arrays;

public class ArrayUpdateConstantTime {
  int[] A, time;
  int globalValue;
  private int timestamp, globalTime;

  public ArrayUpdateConstantTime(int size) {
    A = new int[]{0, 1, 2, 3, 4, 5};
    time = new int[size];
    Arrays.fill(time, 0);
    timestamp = 0;
    globalTime = -1; // means we never call setAllElements
  }

  public int get(int idx) {
    if (time[idx] >=0 && (globalTime == -1 || time[idx] > globalTime)) return A[idx];
    if (globalTime >=0) return globalValue;
    throw new RuntimeException("value in " + idx + " is never set");
  }

  public void set(int idx, int val) {
    time[idx] = timestamp++;
    A[idx] = val;
  }

  public void setAllElements(int val) {
    globalTime = timestamp++;
    globalValue = val;
  }

  public static void main(String... args) {
    ArrayUpdateConstantTime arrayUpdateConstantTime = new ArrayUpdateConstantTime(6);
    System.out.println(arrayUpdateConstantTime.get(1)); // should be 1
    System.out.println(arrayUpdateConstantTime.get(4)); // should be 4
    arrayUpdateConstantTime.set(2, 20);
    System.out.println(arrayUpdateConstantTime.get(2)); // should be 20
    arrayUpdateConstantTime.setAllElements(10);
    System.out.println(arrayUpdateConstantTime.get(5)); // should be 10
    arrayUpdateConstantTime.set(2, 20);
    System.out.println(arrayUpdateConstantTime.get(1)); // should be 10
    System.out.println(arrayUpdateConstantTime.get(2)); // should be 20
    arrayUpdateConstantTime.setAllElements(100);
    System.out.println(arrayUpdateConstantTime.get(1)); // should be 100
    System.out.println(arrayUpdateConstantTime.get(4)); // should be 100
  }
}
