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
    int[] array = new int[]{5, 57, 58, 59}; // should return 3
//    int[] array = new int[]{3, 0, 6, 5, 1};

    // When
    int res = hIndex.hIndex_woExtraSpaceOrChangeInput(array);

    // Than
    assertThat(res, is(1));
  }

}