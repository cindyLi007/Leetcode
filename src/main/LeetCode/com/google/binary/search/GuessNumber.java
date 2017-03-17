package com.google.binary.search;

/**
 * Created by ychang on 1/27/2017.
 * The guess API is defined in the parent class GuessGame.
  pass argument num, your guess
  @return -1 if my number is lower, 1 if my number is higher, otherwise return 0 int guess(int num);
  the most important part is set mid = lo + (hi-lo)/2 instead of (hi+lo)/2, because when lo and hi are huge, the sum of
  them maybe greater than Integer.MAX_VALUE(2^31 - 1).
  The sum overflows to a negative value, and the value stays negative when divided by two.
*/
public class GuessNumber {
  public int guessNumber(int n) {
    int lo = 1, hi = n;
    while (lo<hi) {
      int mid = lo + (hi - lo)/2;
      System.out.print("mid is " + mid);
      int res = guess(mid);
      if (res==0)
        return mid;
      if (res>0) { // the target number is greater, mid number is less, should move lo
        System.out.println(" low add ");
        lo = mid + 1;
      } else { // the target number is less, mid number is greater, should move hi
        System.out.println(" high minus ");
        hi = mid - 1;
      }
    }
    return lo;
  }

  private int guess(int mid) {
    return new Integer(1702766719).compareTo(mid);
  }
}
