package com.google.hash.table;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Created by ychang on 2/9/2017.
 */
public class TopKFrequentElementTest {
  @Test
  public void topKFrequent() throws Exception {
    // Given
    int[] array = new int[]{1, 1, 1, 2, 2, 3};
//    int[] array = new int[]{1, 2};
    TopKFrequentElement topKFrequentElement = new TopKFrequentElement();

    // When
    List<Integer> kList = topKFrequentElement.topKFrequent_TreeMap_Stream(array, 4);

    // Then
    assertThat(kList, is(Arrays.asList(1, 2)));

  }

}