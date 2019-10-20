package interview.google.prepare;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 输入一个list，每个元素包含是一个进程的id和起止时间。
 * 要求输出所有进程的standalone时间（如果有的话）
 */
public class StandaloneProcess {

  // Time: O(NlgN) for
  public List<int[]> standalone(int[][] list) {
    Queue<Process> points = new PriorityQueue<>();
    for (int[] p : list) {
      int start = p[0], end = p[1];
      points.offer(new Process(start, p[2], true));
      points.offer(new Process(end, p[2], false));
    }
    List<int[]> res = new ArrayList<>();
    int count = 0;
    int start = 0;
    Set<Integer> id = new HashSet();
    while (!points.isEmpty()) {
      Process cur = points.poll();
      if (cur.isStart) {
        count++;
        if (count==1) {
          start = cur.time;
        } else if (count==2) {
          res.add(new int[]{start, cur.time, id.iterator().next()}); // start, end, id
        }
        id.add(cur.id);
      } else {
        count--;
        id.remove(cur.id);
        if (count==1) {
          start = cur.time;
        } else if (count==0) {
          res.add(new int[]{start, cur.time, cur.id});
        }
      }
    }
    return res;
  }

  public static void main(String... args) {
    StandaloneProcess standaloneProcess = new StandaloneProcess();
    int[][] process_runtime = {
        {0, 100, 111},
        {150, 240, 222},
        {320, 450, 333},
        {70, 110, 444},
        {130, 190, 555},
        {220, 340, 666}
    };
    List<int[]> standalone = standaloneProcess.standalone(process_runtime);
    for (int[] s : standalone) {
      System.out.println(s[0] + ", " + s[1] + ", " + s[2]);
    }
  }
}


class Process implements Comparable<Process> {
  int time, id;
  boolean isStart;

  Process(int t, int i, boolean e) {
    time = t;
    id = i;
    isStart = e;
  }

  public int compareTo(Process that) {
    return this.time - that.time;
  }
}

/*
ID: 111 beg: 0 end: 100 standalone time: 70
ID: 444 beg: 70 end: 110 standalone time: 10
ID: 555 beg: 130 end: 190 standalone time: 20
ID: 222 beg: 150 end: 240 standalone time: 30
ID: 666 beg: 220 end: 340 standalone time: 80
ID: 333 beg: 320 end: 450 standalone time: 110
 */