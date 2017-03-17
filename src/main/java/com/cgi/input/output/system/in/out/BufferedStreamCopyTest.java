package com.cgi.input.output.system.in.out;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by ychang on 7/10/2016.
 */
public class BufferedStreamCopyTest {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new FileReader(args[0]));
         BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]))) {
      String line;
      while ((line = br.readLine())!= null) {
        bw.write(line);
        bw.newLine();
      }
    } catch (FileNotFoundException f) {
      out.println("File not found: " + f);
    } catch (IOException e) {
      out.println("IOException: " + e);
    }
  }
}
