package com.google.string;

/**
 * Leetcode  415
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class AddStrings {

  public String addStrings(String num1, String num2) {
    // always make num1 is the longer string, could not swap strings in a method since Java is pass-by-value
    if (num1.length() < num2.length()) {
      String temp = num1;
      num1 = num2;
      num2 = temp;
    }
    char[] ch1 = num1.toCharArray(), ch2 = num2.toCharArray();
    int i=num1.length()-1, j=num2.length()-1, carry=0;
    while (i>=0) {
      int n1=ch1[i--]-'0', n2=j>=0 ? ch2[j--]-'0' : 0;
      int sum=n1+n2+carry;
      if (sum>9) {
        /**
         * Notice, when convert digits to char, must ADD '0' and cast to char
         */
        ch1[i+1]=(char)(sum%10 + '0');
        carry=1;
      } else {
        ch1[i+1]=(char)(sum + '0');
        carry=0;
      }
    }
    /**
     * java is pass-by-value, so this will not change the value of String num1, num2
     */
    if (carry==1) {
      return "1"+String.valueOf(ch1);
    }
    return String.valueOf(ch1);
  }

}
