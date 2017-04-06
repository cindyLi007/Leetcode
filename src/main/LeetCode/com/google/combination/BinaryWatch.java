package com.google.combination;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 3/28/2017. This can beat 57%
 */
public class BinaryWatch {
  public List<String> readBinaryWatch(int num) {
    List<String> res = new LinkedList();
    if (num<0)
      return res;
    int[] hours = new int[]{8, 4, 2, 1};
    int[] mins = new int[]{32, 16, 8, 4, 2, 1};
    for (int i = 0; i<=num; i++) {
      List<Integer> upper = generate(hours, i);
      List<Integer> lower = generate(mins, num - i);
      for (int hour : upper) {
        if (hour>11)
          continue;
        for (int min : lower) {
          if (min>59)
            continue;
          res.add(hour + ":" + (min<10 ? "0" + min : min));
        }
      }
    }
    return res;
  }

  private List<Integer> generate(int[] nums, int count) {
    List<Integer> res = new LinkedList();
    generateHelper(nums, count, 0, 0, res);
    return res;
  }

  private void generateHelper(int[] nums, int count, int pos, int sum, List<Integer> res) {
    if (count==0) {
      res.add(sum);
      return;
    }
    for (int i = pos; i<nums.length; i++) {
      generateHelper(nums, count - 1, i + 1, sum + nums[i], res);
    }
  }
}
