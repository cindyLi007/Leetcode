package com.cgi.input.output.system.in.out;

import static java.lang.System.out;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by ychang on 7/10/2016.
 */
public class CharStreamCopyTest {

  public static void main(String[] args) {
    char[] c = new char[128];
    try (FileReader fr = new FileReader(args[0]); FileWriter fw = new FileWriter(args[1])) {
      int count = 0, read;
      while ((read = fr.read(c)) != -1) {
        // must use offset and length, that is because for the last part, we can truncate from last+1 byte to 128
        fw.write(c, 0, read);
        count += read;
      }
      out.println("Wrote: " + count + " characters.");
    } catch (FileNotFoundException f) {
      out.println("File " + args[0] + " not found.");
    } catch (IOException e) {
      out.println("IOException: " + e);
    }
  }
}
