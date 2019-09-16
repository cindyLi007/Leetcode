package interview.amazon.online.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. Partition Labels<br>
 * https://leetcode.com/problems/partition-labels<br><br>
 *
 * Solutions
 * http://zxi.mytechroad.com/blog/string/leetcode-763-partition-labels/
 *
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that
 * each letter appears in at most one part, and return a list of integers representing the size of these parts.<br><br>
 *
 * Note:<br>
 * 1. S will have length in range [1, 500].<br>
 * 2. S will consist of lowercase letters ('a' to 'z') only.
 */
public class PartitionLabel {

  // O(N)
  public List<Integer> partitionLabels(String S) {
    List<Integer> res = new ArrayList();
    if (S==null || S.length()==0) return res;
    int[] lastIndexArray = new int[26];
    for (int i=0; i<S.length(); i++) {
      lastIndexArray[S.charAt(i)-'a'] = i;
    }
    int start=0, end=0;
    for (int i=0; i<S.length(); i++) {
      end = Math.max(end, lastIndexArray[S.charAt(i)-'a']);
      // no any char from start to end appears in substring (end+1)
      if (end==i) {
        res.add(end-start+1);
        // begin a new substring search
        start=end+1;
      }
    }
    return res;
  }
}
