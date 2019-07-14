package com.google.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0]=1;
        for (int i=1; i<n; i++) {
            factorial[i]=i*factorial[i-1];
        }
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<=n; i++) list.add(i);
        k--;
        String s = "";
        for (int i=1; i<=n; i++) {
            int idx = k/factorial[n-i];
            s+=list.get(idx);
//            k-=idx*factorial[n-i];
            k=k%factorial[n-i];
            list.remove(idx);
        }
        return s;
    }

    public static void  main(String... args) {
        PermutationSequence permutationSequence = new PermutationSequence();
        String permutation = permutationSequence.getPermutation(4, 9);
        System.out.println(permutation);
    }
}
