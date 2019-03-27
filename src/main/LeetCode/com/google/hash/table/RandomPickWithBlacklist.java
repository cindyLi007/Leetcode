package com.google.hash.table;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomPickWithBlacklist {
    Set<Integer> set;
    int N;
    Random rand;

    public RandomPickWithBlacklist(int N, int[] blacklist) {
        // do not use new HashSet(Arrays.asList(blacklist)); that could not create a Set containing
        // elements
        set = Arrays.stream(blacklist).boxed().collect(Collectors.toSet());

        this.N = N;
        rand = new Random();
    }

    public int pick() {
        int p = 0;
        do {
            p = rand.nextInt(N);
        } while (set.contains(p));
        return p;
    }
}
