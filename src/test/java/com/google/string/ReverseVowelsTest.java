package com.google.string;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.two.pointers.ReverseVowels;

/**
 * Created by ychang on 12/19/2016.
 */
public class ReverseVowelsTest {
  ReverseVowels instance;

  @Before
  public void setUp() throws Exception {
    instance = new ReverseVowels();
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void reverseVowels() throws Exception {
    // Given
    String testStr = "a.b,.";

    // When
    String res = instance.reverseVowels(testStr);

    // Then
    assertThat(res, is("a.b,."));
  }

}