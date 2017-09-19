package interview.microsoft.onsite;

/**
 * Created by ychang on 8/21/2017.
 */
public class FirstUniqueChar {
  public int firstUniqueChar(String str) {
    char[] ch = str.toCharArray();
    int[] count = new int[256];
    int[] pos = new int[256];

    for (int i = 0; i<ch.length; i++) {
      count[ch[i]]++;
      pos[ch[i]] = i;
    }
    int min = str.length();
    for (int i = 0; i<256; i++) {
      if (count[i]==1 && pos[i]<min)
        min = pos[i];
    }
    return min==str.length() ? -1 : min;
  }
}
