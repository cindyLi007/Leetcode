package com.cgi.input.output.system.in.out;

import static java.lang.System.exit;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ychang on 7/10/2016.
 */
public class KeyboardInput {

  public static void main(String[] args) {
    String s;
    try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
      out.print("type xyz to exit: ");
      s = in.readLine();
      while (s != null) {
        out.println("Read: " + s.trim());
        if (s.equals("xyz")) {
          exit(0);
        }
        out.print("Type xyz to exit: ");
        s = in.readLine();
      }
    } catch (IOException e) {
      out.println("Exception: " + e);
    }

  }
}
