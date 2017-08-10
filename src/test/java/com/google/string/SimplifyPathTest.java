package com.google.string;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 5/10/2017.
 */
public class SimplifyPathTest {
  @Test
  public void simplifyPath() throws Exception {
    // Given
    SimplifyPath simplifyPath = new SimplifyPath();

    // When
//    String path = simplifyPath.simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///");
    String path = simplifyPath.simplifyPath("/...");

    // Then
    assertThat(path, is("/c"));
  }

}