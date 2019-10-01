package interview.google.prepare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 1088, similar with Leetcode 1012 Numbers With Repeated Digits,
 * Idea: first calculate how many number totally, then minus the not-qualified number
 * also related to 1087 and 248
 */
public class ConfusionNumberII {
  Map<Integer, Integer> map = new HashMap<Integer, Integer>(){
    {
      put(0, 0);
      put(1, 1);
      put(6, 9);
      put(8, 8);
      put(9, 6);
    }
  };

  public int confusingNumberII(int N) {

    // first count how many numbers from 1 to N construct with "0, 1, 6, 8, 9"
    // must use N+1 because we want to include N
    String NS = String.valueOf(N+1);
    // L stands for how many digits in N+1
    int L = NS.length();
    int[] digit = new int[L];
    for (int i=0; i<L; i++) digit[i]=NS.charAt(i)-'0';

    // first compute number less than num and do not have most leading decimal, for ex. if num is 6822, we will count
    // from 1 to 999
    int count=0;
    // leading number must be from {1, 6, 8, 9} so it is 4 numbers, after that, it can be {0, 1, 6, 8, 9}, so it is 5
    for (int i=1; i<L; i++) {
      count += 4 * (int)Math.pow(5, i-1);
    }
    // now count is the toall number construct with "0, 1, 6, 8, 9} from [1, M] M is the number without leading digit

    // compute [M+1, N] for ex. if num is 7822, compute from [1000, 6822)
    // from the most significant digit, for each one choose small that digit key from {0, 1, 6, 8, 9}
    for (int i=0; i<L; i++) {
      int d = digit[i];
      // if now is the most significant digit and it is 1, we could not choose 0, so skip
      if (i==0 && d==1) continue; 
      for (Integer key : map.keySet()) {
        // we only choose key less than current d, for 6822, if now we hanle 8, we only check 60xx, 61xx, 66xx
        if (key.intValue() < d) {
          if (i==0 && key.intValue() == 0) continue;
          count += Math.pow(5, L-i-1);
        } else {
          break;
        }
      }
      // if current d is not one of {0, 1, 6, 8, 9}, we could start with it, should stop. for ex. 7899, after we count 1xxx, 6xxx, we could not count 7xxx
      if (!map.containsKey(d)) break;
    }

    return count - helper(N);
  }

  // Calculate all numbers which is Strobogrammatic number from [1, N]
  private int helper(int N) {
    String NS = String.valueOf(N);
    int L = NS.length();
    // if L==1, only can choose 1, 8
    if (L==1) return N < 8 ? 1 : 2;

    int count = 0;
    List<String>[] list = (List<String>[])new ArrayList[L+1];
    list[0] = new ArrayList<String>(){{add("");}};
    list[1] = new ArrayList<String>(){{add("0"); add("1"); add("8"); }};
    // for L==1, 2 numbers 1, 8
    count += 2;

    // for each L i, use i-2 as the middle and add pair
    for (int i=2; i<=L; i++) {
      List<String> prev = list[i - 2];
      list[i] = new ArrayList<>();

      for (String s : prev) {
        for (Integer k : map.keySet()) {
          // could not append 0 as the most significant digit
          if (k==0 && i==L) continue;
          String res = k.toString() + s + map.get(k).toString();
          if (i==L && res.compareTo(NS) > 0) break;
          list[i].add(res);
          // if i<L we can add for ex. 080 to list, so later it can be 80808, but we should not count it
          if (!res.startsWith("0")) count++;
        }
      }
    }
    return count;
  }

  public static void main(String... args) {
    ConfusionNumberII confusionNumberII = new ConfusionNumberII();
    System.out.println(confusionNumberII.confusingNumberII(9950));
  }
}
