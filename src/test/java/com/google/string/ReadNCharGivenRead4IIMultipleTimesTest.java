package com.google.string;

import org.junit.Test;

/**
 * Created by ychang on 4/26/2017.
 */
public class ReadNCharGivenRead4IIMultipleTimesTest {

  @Test
  public void read() throws Exception {
    // Given
    ReadNCharGivenRead4IIMultipleTimes read4IIMultipleTimes = new ReadNCharGivenRead4IIMultipleTimes();
    char[] buff = new char[5];

    // When
    read4IIMultipleTimes.read(buff, 1);
    read4IIMultipleTimes.read(buff, 2);

    // Then

  }

}