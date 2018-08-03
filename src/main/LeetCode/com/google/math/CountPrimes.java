package com.google.math;

/**
 * Created by ychang on 8/10/2017.
 * Count the number of prime numbers less than a non-negative number, n.
 * 0, 1 is neither prime or composite number. 2 is the smallest prime number, all non-prime numbers can be divisible by a prime number,
 */
public class CountPrimes {
  public int countPrimes(int n) {
    if (n<=2) return 0;
    boolean[] noPrimes = new boolean[n];
    for (int p=2; p<=Math.sqrt(n);) {
      // mark all noPrime numbers divided by p
      for (int i=p*p; i<n; i+=p) {
        noPrimes[i]=true;
      }
      /**
       * find next prime number, notice here j must compare with n instead of sqrt(n), otherwise we maybe not find next prime
       * and into unlimited loop
       */
      for (int j=p+1; j<n; j++) {
        if (!noPrimes[j]) {
          p=j;
          break;
        }
      }
    }
    int count=0;
    for (int i=2; i<n; i++) {
      if (!noPrimes[i]) count++;
    }
    return count;
  }

}
