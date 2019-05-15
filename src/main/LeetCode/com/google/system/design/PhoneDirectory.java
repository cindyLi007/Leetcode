package com.google.system.design;

import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class PhoneDirectory {
    int N;
    Set<Integer> availableNumbers;

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        N = maxNumbers;
        availableNumbers = IntStream.range(0, N).boxed().collect(Collectors.toSet());
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        Iterator<Integer> it = availableNumbers.iterator();
        if (it.hasNext()) {
            int i = it.next();
            availableNumbers.remove(i);
            return i;
        }
        return -1;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return availableNumbers.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        availableNumbers.add(number);
    }
}