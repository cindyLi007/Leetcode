package com.google.binary.search.tree;

import static java.lang.Boolean.FALSE;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

/**
 * Created by ychang on 2/1/2017.
 */
public class ContainDuplicateTest {

  @Test
  public void containsNearbyAlmostDuplicate() throws Exception {
    // Given
    ContainDuplicate cd = new ContainDuplicate();
    int[] array = new int[]{0,10,22,15,0,5,22,12,1,5};

    // When
    boolean res = cd.containsNearbyAlmostDuplicate(array, 3, 3);

    // Then
    assertThat(res, is(FALSE));
  }

}