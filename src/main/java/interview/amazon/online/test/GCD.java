package interview.amazon.online.test;

// find GCD of all numbers of an array, for ex. [2, 4, 6, 8, 10], the result is 2
public class GCD {
    public int generalizedGCD(int num, int[] arr)
    {
        int res = arr[0];
        for (int i=1; i<arr.length; i++) {
            res = gcd(arr[i], res);
        }
        return res;
    }

    private int gcd(int a, int b) {
        if (a==0) return b;
        return gcd(b%a, a);
    }
}
