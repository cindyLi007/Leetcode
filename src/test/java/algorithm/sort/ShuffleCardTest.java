package algorithm.sort;

import org.junit.Test;

/**
 * Created by ychang on 1/17/2017.
 */
public class ShuffleCardTest {
  @Test
  public void shuffle() throws Exception {
    ShuffleCard shuffleCard = new ShuffleCard();
    shuffleCard.shuffle(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10});
  }
}