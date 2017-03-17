package com.cgi.file;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ychang on 7/11/2016.
 */
public class BufferedReaderTest {

  public static void main(String[] args) {
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]))) {
      bufferedReader.lines().forEach(line -> out.println(line));
    } catch (FileNotFoundException e) {
      out.println("Error: " + e.getMessage());
    } catch (IOException e) {

    }
  }
}
