package com.google.design;

import org.junit.Test;

/**
 * Created by ychang on 3/31/2017.
 */
public class HitCounterTest {
  @Test
  public void hit() throws Exception {
    // Given
    HitCounter hitCounter = new HitCounter();

    // When
    hitCounter.hit(1);
    hitCounter.hit(1);
    hitCounter.hit(1);
    hitCounter.hit(300);
    System.out.println(hitCounter.getHits(300));
    hitCounter.hit(300);
    System.out.println(hitCounter.getHits(300));
    hitCounter.hit(301);
    System.out.println(hitCounter.getHits(301));
  }

}