package com.cgi.file;

import static java.lang.System.out;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by ychang on 7/11/2016.
 */
public class NioReaderTest {

  public static void main(String[] args) {
    try (Stream<String> lines = Files.lines(Paths.get(args[0]) )) {
      lines.forEach(line -> out.println(line));
    } catch (FileNotFoundException e) {
      out.println("Error: " + e.getMessage());
    } catch (IOException e) {

    }
  }
}
