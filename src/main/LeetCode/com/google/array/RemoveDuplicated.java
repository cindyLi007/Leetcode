package com.google.array;

/**
 * Created by ychang on 3/15/2017.
 */
public class RemoveDuplicated {
  public int removeDuplicates(int[] nums) {
    int i = 0; // i is the position of last no-dup item
    for (int j = 1; j < nums.length; j++) { // j is the running pointer
      if (nums[j] != nums[i]) { // when current item is NOT duplicated with prev one
        nums[++i] = nums[j];
      }
    }
    return i + 1;
  }

  public int removeDuplicates_II(int[] nums) {
    int i = 0;
    for (int j = 2; j < nums.length; j++) {
      if (nums[j] != nums[i]) {
        i += 2;
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }

  // 1047. Remove All Adjacent Duplicates In String
  public static String removeDuplicates(String S) {
    char[] res = S.toCharArray();
    int i = 0, N = res.length;
    for (int j = 0; j < N; j++, i++) {
      // 每一次先把当下loop的char放到res[i]中，然后判断这个新放入的char会不会和前面的重复，实际上是在模拟人的思维
      res[i] = res[j];
      if (i > 0 && res[i] == res[i - 1]) {
        i -= 2;
      }
    }
    return new String(res, 0, i);
  }

  public static void main(String... args) {
    String s = removeDuplicates("aaaaaaaa");
  }


}
