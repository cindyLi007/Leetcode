package algorithm.sort;

import java.util.Random;

/**
 * Created by ychang on 1/17/2017.
 * In iteration i, pick integer r [0, i] uniformly at random, swap a[i] to a[r]
 */
public class ShuffleCard {
  public void shuffle(int[] cards) {
    for (int i=0; i<cards.length; i++) {
      Random random = new Random();
      /**
       * must from 0 to i, could not 0 to N-1, because that is NOT uniformly random
       */
      int rand = random.nextInt(i+1); // (i+1) is between 0 to i
      System.out.println("i is " + i + " and random is " + rand);
      swap(cards, i, rand);
    }
  }

  private void swap(int[] cards, int i, int rand) {
    int temp = cards[rand];
    cards[rand]=cards[i];
    cards[i]=temp;
  }
}
