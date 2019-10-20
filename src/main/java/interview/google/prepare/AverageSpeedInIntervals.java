package interview.google.prepare;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入很多interval, 每个interval有一个速度。要求返回每个路段的平均速度（高级版merge interval）
 */
public class AverageSpeedInIntervals {

  public static List<Interval> findAverageSpeed(List<Interval> intervals) {
    List<double[]> timePoints = new ArrayList<>();
    for (Interval i : intervals) {
      timePoints.add(new double[]{(double) i.start, i.speed});
      timePoints.add(new double[]{(double) i.end, -i.speed});
    }
    timePoints.sort((o1, o2) -> Double.compare(o1[0], o2[0]) == 0 ?
        Double.compare(o2[1], o1[1]) : Double.compare(o1[0], o2[0]));
    List<Interval> res = new ArrayList<>();
    int start = 0, count = 0;
    double sum = 0.0;
    for (double[] entry : timePoints) {
      if (count > 0 && start < (int) entry[0]) {
        res.add(new Interval(start, (int) entry[0], sum / count));
      }
      count = entry[1] > 0 ? count+1: count-1;
      sum += entry[1];
      start = (int) entry[0];
    }
    return res;
  }

  public static void main(String... args) {
    List<Interval> intervals = new ArrayList<>();
    intervals.add(new Interval(0, 2, 2.0));
    intervals.add(new Interval(1, 5, 3.0));
    intervals.add(new Interval(4, 9, 4.0));
    intervals.add(new Interval(4, 8, 5.0));
    intervals.add(new Interval(9, 10, 8.0));
    List<Interval> averageSpeed = findAverageSpeed(intervals);
    for (Interval i : averageSpeed) {
      System.out.println(i);
    }
  }
}

class Interval {
  int start, end;
  double speed;

  Interval(int s, int e, double p) {
    this.speed = p;
    this.start = s;
    this.end = e;
  }

  @Override
  public String toString() {
    return "Start Time: " + start + " End Time: " + end + " Speed: " + speed;
  }
}
