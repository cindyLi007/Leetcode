package com.google.bit.manipulation;

/**
 * Created by ychang on 12/15/2016.
 * One byte (one number) <128 128 is 1000 0000, but one byte should be 0xxx xxxx
 * 2 bytes (1st >=192, 2nd [128, 192) 192 is 1100 0000 but 2nd should be 10xx xxxx
 * 3 bytes (1st >=224, 2nd & 3rd [128, 192) 224 is 1110 xxxx
 * 4 bytes (1st >=240, 2nd, 3rd and 4th [128, 192), 240 is 1111 xxxx
 */
public class UTF8Validation {
  // Time: O(N), Space: O(1)
  public boolean validUtf8_useValue(int[] data) {
    if (data==null || data.length==0)
      return true;
    int bits = 0;
    for (int i : data) {
      if ((bits!=0 && i>=192) || (bits==0 && (i>=248 || (i>128 && i<192))))
        return false;
      // if we can step here, that means so far the data is valid UTF-8, we focus one process the data, not check valid
      if (i>=240) { // the 4 bytes beginning
        bits = 3;
      } else if (i>=224) { //the 3 bytes beginning
        bits = 2;
      } else if (i>=192) { //the 2 bytes beginning
        bits = 1;
      } else if (i>=128) { // the 4-byte, 3-byte and 2-byte remaining bytes
        bits--;
        if (bits<0)
          return false; // if bits<0, that means do not have heading integer for 4-byte, 3-byte and 2-byte
      }
    }
    return bits==0; // if bits>0, that means missing 4-byte, 3-byte and 2-byte remaining bytes
  }

  // Time: O(N*8), Space: O(1)
  public boolean validUtf8_bitManipulation(int[] data) {
    int bytes = 0;
    int mask = 1<<7;
    for (int num : data) {
      if (bytes==0) {
        if ((num & mask) == 0) continue;
        while ((num & mask)!=0) {
          num<<=1;
          bytes++;
        }
        if (bytes>4 || bytes<2) return false;
        bytes--;
      } else {
        if ((num & mask)!=0 && (num & (1<<6))==0) {
          bytes--;
        } else {
          return false;
        }
      }
    }
    return bytes==0;
  }

  public static void main(String[] args) {
    UTF8Validation utf8Validation = new UTF8Validation();
    int[] data = new int[]{235, 140, 140, 140, 4};
    boolean res = utf8Validation.validUtf8_bitManipulation(data);
    System.out.println(res);
  }
}
