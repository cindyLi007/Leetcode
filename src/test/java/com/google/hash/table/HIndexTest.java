package com.google.hash.table;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 3/28/2017.
 */
public class HIndexTest {
  @Test
  public void hIndex() throws Exception {
    // Given
    HIndex hIndex = new HIndex();
    int[] array = new int[]{5, 57, 58, 59};

    // When
    int res = hIndex.hIndex_woSort(array);

    // Than
    assertThat(res, is(3));
  }

}