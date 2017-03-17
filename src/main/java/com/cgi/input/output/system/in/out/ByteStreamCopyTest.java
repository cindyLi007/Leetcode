package com.cgi.input.output.system.in.out;

import static java.lang.System.out;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ychang on 7/10/2016.
 */
public class ByteStreamCopyTest {

  public static void main(String[] args) {
    byte[] b = new byte[128];
    try (FileInputStream fis = new FileInputStream(args[0]); FileOutputStream fos = new FileOutputStream(args[1])) {
      out.println("Bytes available: " + fis.available());
      int count = 0, read;
      while ((read = fis.read(b)) != -1) {
        // must use offset and length, that is because for the last part, we can truncate from last+1 byte to 128
        fos.write(b, 0, read);
        count += read;
      }
      out.println("Wrote: " + count);
    } catch (FileNotFoundException f) {
      out.println("File not found: " + f);
    } catch (IOException e) {
      out.println("IOException: " + e);
    }
  }
}
