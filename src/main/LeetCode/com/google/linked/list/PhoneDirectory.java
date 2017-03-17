package com.google.linked.list;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ychang on 3/6/2017. Can only beat 10%
 */
public class PhoneDirectory {
  Set<Integer> numbers;
  final int max;

  /**
   * Initialize your data structure here
   * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
   */
  public PhoneDirectory(int maxNumbers) {
    max = maxNumbers;
    numbers = new HashSet();
    for (int i = 0; i<max; i++)
      numbers.add(i);
  }

  /**
   * Provide a number which is not assigned to anyone.
   * @return - Return an available number. Return -1 if none is available.
   */
  public int get() {
    // if (numbers.isEmpty()) return -1;
    for (int i : numbers) {
      numbers.remove(i);
      return i;
    }
    return -1;
  }

  /**
   * Check if a number is available or not.
   */
  public boolean check(int number) {
    return numbers.contains(number);
  }

  /**
   * Recycle or release a number.
   */
  public void release(int number) {
    if (number<max && number>=0) {
      numbers.add(number);
    }
  }

  public static void main(String[] args) {
    PhoneDirectory phoneDirectory = new PhoneDirectory(10);
    for (int i = 0; i<10; i++) {
      System.out.print(phoneDirectory.get()+" ");
    }
    System.out.println();
    System.out.println(phoneDirectory.check(3));
    phoneDirectory.release(7);
    phoneDirectory.release(3);
    System.out.println(phoneDirectory.get());
    phoneDirectory.release(1);
    System.out.println(phoneDirectory.get());
  }
}
