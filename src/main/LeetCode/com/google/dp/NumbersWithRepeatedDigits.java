package com.google.dp;

import java.util.*;

/**
 * https://www.youtube.com/watch?v=b0e0kM4QmWw
 * Leetcode 1012
 * we should calculate all "without repeated digits number"
 */
public class NumbersWithRepeatedDigits {
  public static int numDupDigitsAtMostN(int N) {
    // must use N+1, that is because we maybe include N itself as no repeated digits
    int number = N+1;
    // list stores all digits from right to left in N
    List<Integer> list = new ArrayList();
    while (number>0) {
      list.add(number%10);
      number/=10;
    }
    Collections.reverse(list);

    int L=list.size();
    int res=0;
    // Count all length < L no-repeated numbers, i is the length of the number, all those numbers do not depend on N's digits
    for (int i=1; i<L; i++) {
      res += 9 * P(9, i-1);
    }

    // Count all length==L no repeated numbers
    Set<Integer> set = new HashSet(); // use this to record which digit has be seen
    for (int i=0; i<L; i++) { // i is the index of leading digit, i==0 means we choose the most-right digit of N
      int digit = list.get(i);
      // if i==0 that means we process the first digit of N, it could not 0, so from 1
      int j = (i==0) ? 1 : 0;
      // fix the leading digits as j, now the length is L-1-i (we can image as if i==0, we fix the most right digit as j, there is L-1 positions left)
      for (; j<digit; j++) {
        if (!set.contains(j)) res += P(9-i, L-i-1);
      }
      // if we see digit, that mean the N has repeat digit, then from this digit, all number with prefix till digit could not be count as no repeat digit, stop
      if (set.contains(digit)) break;
      set.add(digit);
    }
    return number-res;
  }

  // calculate P(n, m) = n*(n-1)*...(n-m+1)
  // P(n, 0) = 1, means there is no pos to put
  private static int P(int n, int m) {
    int res = 1;
    for (int i=n-m+1; i<=n; i++) res*=i;
    return res;
  }

  public static void main(String... args) {
    System.out.println(numDupDigitsAtMostN(20));
    System.out.println(numDupDigitsAtMostN(100)); // should be 10
    System.out.println(numDupDigitsAtMostN(1000)); // should be 262
  }
}
