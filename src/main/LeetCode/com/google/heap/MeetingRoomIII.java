package com.google.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by ychang on 10/10/2017.
 */
public class MeetingRoomIII {
  public List<List<int[]>> meetingRoomSchedule(List<Interval> meetings) {
    // sort meetings based on start
    Collections.sort(meetings, (o1, o2) -> o1.start == o2.start ? o1.end-o2.end : o1.start-o2.start);

    List<List<int[]>> res = new ArrayList();

    // keep a Priority Queue for earliest end
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.offer(meetings.get(0).end);
    List<int[]> list = new LinkedList();
    list.add(new int[]{meetings.get(0).start, meetings.get(0).end});
    res.add(list);
    Map<Integer, Integer> map = new HashMap<>();
    map.put(meetings.get(0).end, 0);

    for (int i=1; i<meetings.size(); i++) {
      Interval cur = meetings.get(i);
      int end = pq.poll();
      if (cur.start>=end) { // we can use the existing meeting rooms;
        res.get(map.get(end)).add(new int[]{cur.start, cur.end});
      } else {
        List newList = new LinkedList();
        newList.add(new int[]{cur.start, cur.end});
        res.add(newList);
        map.put(cur.end, res.size()-1);
      }
      pq.offer(cur.end);
    }

    print(res);
    return res;
  }

  private void print(List<List<int[]>> res) {
    for (int i=0; i<res.size(); i++) {
      List<int[]> list = res.get(0);
      for (int[] elem : list) {
        System.out.println(elem[0] + "  " + elem[1]);
      }
    }
  }
}
