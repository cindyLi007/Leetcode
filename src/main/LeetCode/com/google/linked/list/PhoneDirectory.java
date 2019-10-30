package com.google.linked.list;

import java.util.BitSet;

/**
 * Created by ychang on 3/6/2017. this one can beat 94%
 */
public class PhoneDirectory {
  BitSet numbers;
  final int max;
  int smallestAvailableNumber;

  /**
   * Initialize your data structure here
   * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
   */
  public PhoneDirectory(int maxNumbers) {
    max = maxNumbers;
    numbers = new BitSet(max);
  }

  /**
   * Provide a number which is not assigned to anyone.
   * @return - Return an available number. Return -1 if none is available.
   */
  public int get() {
    if (smallestAvailableNumber==max)
      return -1;
    int res = smallestAvailableNumber;
    numbers.set(smallestAvailableNumber);
    smallestAvailableNumber = numbers.nextClearBit(smallestAvailableNumber);
    return res;
  }

  /**
   * Check if a number is available or not.
   */
  public boolean check(int number) {
    return !numbers.get(number);
  }

  /**
   * Recycle or release a number.
   */
  public void release(int number) {
    if (number<max && number>=0 && numbers.get(number)) {
      numbers.clear(number);
      if (number<smallestAvailableNumber)
        smallestAvailableNumber = number;
    }
  }

  public static void main(String[] args) {
    PhoneDirectory phoneDirectory = new PhoneDirectory(1); // null
    System.out.println(phoneDirectory.check(0)); // true
    System.out.println(phoneDirectory.get()); //0
    System.out.println(phoneDirectory.check(0)); //false
    System.out.println(phoneDirectory.get()); // -1
    phoneDirectory.release(0); //null
    System.out.println(phoneDirectory.check(0)); //true
    System.out.println(phoneDirectory.get()); // 0
    System.out.println(phoneDirectory.get()); // -1
  }
}
