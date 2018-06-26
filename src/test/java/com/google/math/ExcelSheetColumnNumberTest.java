package com.google.math;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ExcelSheetColumnNumberTest {

  @Test
  public void titleToNumber() {

    // Given
    ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();

    // When
    int d = excelSheetColumnNumber.titleToNumber("D");
    int aa = excelSheetColumnNumber.titleToNumber("AA");
    int zz = excelSheetColumnNumber.titleToNumber("ZZ");

    // Then
    assertThat(d, is(4));
    assertThat(aa, is(27));
    assertThat(zz, is(702));
  }
}