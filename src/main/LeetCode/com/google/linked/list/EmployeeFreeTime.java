package com.google.linked.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFreeTime {

    // Time: O(n*lgN) for sorting
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> list = schedule.stream().flatMap(List::stream).collect(Collectors.toList());
        Collections.sort(list, (o1, o2)-> o1.start==o2.start ? o1.end - o2.end : o1.start - o2.start);

        int end = list.get(0).end;
        List<Interval> res = new ArrayList();
        for (Interval i : list) {
            if (i.start > end) {
                res.add(new Interval(end, i.start));
            }
            end = Math.max(end, i.end);
        }
        return res;
    }
    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start,int _end) {
            start = _start;
            end = _end;
        }
    }
}
