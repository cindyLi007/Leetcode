package com.cgi.file;

import static java.lang.System.out;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by ychang on 7/11/2016.
 */
public class NioReaderReadAll {

  public static void main(String[] args) {
    Path file = Paths.get(args[0]);
    List<String> fileArr;

    try {
      fileArr = Files.readAllLines(file);
      fileArr.stream().filter(line -> line.contains("select"))
                      .forEach(line -> out.println(line));
      long wordCount = fileArr.stream().flatMap(line -> Stream.of(line.split(" ")))
                                      .filter(word -> word.contains("update"))
                                      .peek(word -> out.println(word))
                                      .count();
      out.println(wordCount);
      fileArr.stream().filter(line -> line.contains("go"))
                      .forEach(line -> out.println(line));
    } catch (FileNotFoundException e) {
      out.println("Error: " + e.getMessage());
    } catch (IOException e) {
      out.println("Error: " + e.getMessage());
    }
  }
}
