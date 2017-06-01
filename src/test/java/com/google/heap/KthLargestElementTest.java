package com.google.heap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 5/10/2017.
 */
public class KthLargestElementTest {
  @Test
  public void findKthLargest() throws Exception {
    // Given
    KthLargestElement kthLargestElement = new KthLargestElement();

    // When
    int result = kthLargestElement.findKthLargest(new int[]{3,2,3,0,3,2,1,5,6,4}, 2);

    // Then
    assertThat(result, is(2));
  }

}