package com.google.string;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTime {
    public String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();
        for (char c : time.toCharArray()) {
            if (c!=':') set.add(c-'0');
        }
        if (set.size()==1) return time;
        int cur = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
        for (int i=1; i<=24*60; i++) {
            int t = (cur+i)%(24*60);
            int hour = t/60, min=t%60;
            if (set.contains(hour/10) && set.contains(hour%10) &&
                    set.contains(min/10) && set.contains(min%10))
                return String.format("%02d:%02d", hour, min);
        }
        return "";
    }

    public static void main(String... args) {
        NextClosestTime nextClosestTime = new NextClosestTime();
        String nextClosestTime1 = nextClosestTime.nextClosestTime("19:34");
        System.out.println(nextClosestTime1);
    }
}
