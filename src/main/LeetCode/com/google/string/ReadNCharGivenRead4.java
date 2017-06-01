package com.google.string;

/**
 * Created by ychang on 4/26/2017.
 * The read4 API is defined in the parent class Reader4. It read 4 chars from file to buf.
 * int read4(char[] buf);
 */
public class ReadNCharGivenRead4 {
  /**
   * @param buf Destination buffer
   * @param n   Maximum number of characters to read
   * @return The number of characters read
   * the implementation of this method has 2 effects, 1) buf is filled with char from file, 2) return total char read from file
   */
  public int read(char[] buf, int n) {
    char[] temp = new char[4];
    // first read char to temp from file
    int count = read4(temp);
    int total = 0;
    while (total<n) {
      for (int i = 0; i<count && total<n; i++)
        buf[total++] = temp[i];
      if (count<4) // count<4 means read to end of the file
        break;
      count = read4(temp);
    }
    return total;
  }

  private int read4(char[] temp) {
    return 0;
  }
}
