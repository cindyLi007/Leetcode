package com.google.bit.manipulation;

/**
 * Created by ychang on 12/15/2016.
 * One byte (one number) <128 128 is 1000 0000, but one byte should be 0xxx xxxx
 * 2 bytes (1st >=192, 2nd [128, 192) 192 is 1100 0000 but 2nd should be 10xx xxxx
 * 3 bytes (1st >=224, 2nd & 3rd [128, 192) 224 is 1110 xxxx
 * 4 bytes (1st >=240, 2nd, 3rd and 4th [128, 192), 240 is 1111 xxxx
 */
public class UTF8Validation {
  public boolean validUtf8(int[] data) {
    if (data==null || data.length==0)
      return true;
    int bits = 0;
    for (int i : data) {
      if (i>=240) { // the 4 bytes beginning
        if (bits!=0)
          return false;
        bits = 3;
      } else if (i>=224) { //the 3 bytes beginning
        if (bits!=0)
          return false;
        bits = 2;
      } else if (i>=192) { //the 2 bytes beginning
        if (bits!=0)
          return false;
        bits = 1;
      } else if (i>=128) { // the 4-byte, 3-byte and 2-byte remaining bytes
        bits--;
        if (bits<0)
          return false; // if bits<0, that means do not have heading integer for 4-byte, 3-byte and 2-byte
      }
    }
    return bits==0; // if bits>0, that means missing 4-byte, 3-byte and 2-byte remaining bytes
  }

  public boolean validUtf8_simplify(int[] data) {
    if (data==null || data.length==0)
      return true;
    int bits = 0;
    for (int i : data) {
      if (bits!=0 && i>=192 || i>=248)
        return false;
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

  public static void main(String[] args) {
    UTF8Validation utf8Validation = new UTF8Validation();
    int[] data = new int[]{235, 140, 140, 140, 4};
    boolean res = utf8Validation.validUtf8(data);
    System.out.println(res);
  }
}
