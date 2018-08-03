package com.google.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by grchan on 7/26/2018
 */
public class Permutations {
  public List<List<Integer>> permute(int[] nums) {
    List<Integer> list = new ArrayList<>();
    for (int i : nums) {
      list.add(i);
    }
    // this is much slower then directly added as above
//    List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
    List<List<Integer>> res = new ArrayList<>();
    directedPermute(0, list, res);
    return res;
  }

  private void directedPermute(int i, List<Integer> list, List<List<Integer>> res) {
    if (i==list.size()-1) {
      res.add(new ArrayList(list));
    } else {
      for (int j=i; j<list.size(); j++) {
        Collections.swap(list, i, j);
        directedPermute(i+1, list, res);
        Collections.swap(list, i, j);
      }
    }
  }
}
