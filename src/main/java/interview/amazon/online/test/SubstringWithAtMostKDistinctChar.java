package interview.amazon.online.test;

/**
 * Created by ychang on 5/6/2018.
 *
 * Given a string you need to print longest possible substring that has exactly M unique characters. If there are
 * more than one substring of longest possible length, then print any one of them.
 *
 * can beat 93%
 */
public class SubstringWithAtMostKDistinctChar {

  /**
   * Use array instead of Set or HashMap to improve performance
   */
  public int substringWithKDistinctChar(String s, int k) {
    if (k <=0 || s == null || s.length()==0) {
      return 0;
    }

    int[] countArray = new int[128];
    int start=0, count=0, res=0;
    for (int i=0; i<s.length(); i++) {
      int c = s.charAt(i);
      if (countArray[c]==0) {
        count++;
      }
      countArray[c]++;
      if (count>k) { // need remove a char which last index is most front
        res = Math.max(res, i-start);
        // need reset start to (the last index of the removed char +1)
        while (count>k) {
          int index = s.charAt(start++);
          countArray[index]--;
          if (countArray[index]==0) {
            count--;
          }
        }
      }
    }
    res = Math.max(s.length()-start, res);
    return res;
  }
}
