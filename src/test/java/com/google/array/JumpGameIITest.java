package com.google.array;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class JumpGameIITest {

  @Test
  public void jump() {
    // Given
    JumpGameII jumpGameII = new JumpGameII();
    int[] array = new int[]{2, 1, 3, 1, 1, 1, 1};
//    int[] array = new int[]{0};

    // When
    int steps = jumpGameII.jump(array);

    // Then
    assertThat(steps, is(3));
  }
}