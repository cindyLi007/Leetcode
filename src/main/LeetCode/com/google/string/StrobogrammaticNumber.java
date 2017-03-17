package com.google.string;

/**
 * Created by ychang on 12/14/2016.
 * We need make it in-place, which means should NOT create another string and compare with the original one.
 * it is like Palindrome string compare, the only difference is for 69 and if the number is 2, 3, 4, 5, 7, need
 * return false
 */
public class StrobogrammaticNumber {
  public boolean isStrobogrammatic(String num) {
    /**
     * must have i<=j, otherwise for string "2", return true (should return false)
     */
    for (int i=0, j=num.length()-1; i<=j; i++, j--) {
      String s = num.charAt(i) + "" + num.charAt(j);
      /**
        need have a space for each pair, otherwise for "18" still return true
       */
      if (!"00 11 88 69 96".contains(s)) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    StrobogrammaticNumber sn = new StrobogrammaticNumber();
    boolean res = sn.isStrobogrammatic("6");
    System.out.println(res);
  }
}
