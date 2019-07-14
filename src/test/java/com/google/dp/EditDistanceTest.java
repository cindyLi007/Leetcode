package com.google.dp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 * Created by ychang on 5/3/2017.
 */
public class EditDistanceTest {
  @Test
  public void minDistance() throws Exception {
    /**
     * this part is to test iterator, when iterator.hasNext() is false, if we call next(), it will throw an
     * java.util.NoSuchElementException, Java use iterator as a pointer, whenever we call next(), the cursor move forward,
     * even in debug.
     */
    List<String> testList = Arrays.asList("Grace", "Google", "Apple", "LinkedIn", "Microsoft");
    Iterator<String> iterator = testList.iterator();
    for (int i=0; i<6; i++) {
      System.out.println(iterator.next());
    }

    // Given
    EditDistance editDistance = new EditDistance();

    // When
//    int distance = editDistance.minDistance("zoologicoarchaeologist", "zoogeologist");
    int distance = editDistance.minDistance("horse", "ros");

    // Then
    assertThat(distance, is(10));
  }

}