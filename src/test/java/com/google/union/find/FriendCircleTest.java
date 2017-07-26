package com.google.union.find;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 6/15/2017.
 */
public class FriendCircleTest {
  @Test
  public void findCircleNum() throws Exception {
    // Given
    FriendCircle friendCircle = new FriendCircle();
//    int[][] friend = new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
    int[][] friend = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

    // When
    int circleNum = friendCircle.findCircleNum(friend);

    // Then
    assertThat(circleNum, is(1));
  }

}