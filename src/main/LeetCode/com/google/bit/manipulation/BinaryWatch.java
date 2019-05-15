package com.google.bit.manipulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 3/28/2017. This can beat 31%, faster solution is in leetcode submission
 */
public class BinaryWatch {
    // Time: O(12*60*bitCount), bitCount is about 10bit.
    public List<String> readBinaryWatch(int num) {
        List<String> res = new LinkedList();
        for (int hour = 0; hour < 12; hour++) {
            for (int min = 0; min < 60; min++) {
                /**
                 * the reason hour shift right 6 bits is to avoid they do sum to mess up bits
                 */
                if (Integer.bitCount((hour << 6) + min) == num) {
                    res.add(String.format("%d:%02d", hour, min));
                }
            }
        }
        return res;
    }

    public List<String> readBinaryWatch_backtrack(int num) {
        int[] LED = new int[]{8, 4, 2, 1, 32, 16, 8, 4, 2, 1};
        List<String> res = new ArrayList<>();
        backtrack(num, LED, res, 0, 0, 0);
        return res;
    }

    private void backtrack(int num, int[] LED, List<String> res, int start, int h, int m) {
        if (h>11 || m>59) return;
        if (num==0) {
            res.add(h+":"+ (m<10 ? "0"+m : m));
            return;
        }
        for (int i=start; i<LED.length; i++) {
            if (i<=3) h+=LED[i];
            else m+=LED[i];
            backtrack(num-1, LED, res, i+1, h, m);
            if (i<=3) h-=LED[i];
            else m-=LED[i];
        }
    }
}
