package interview.google.prepare;

// https://leetcode.com/discuss/interview-question/394347/
public class WateringFlowers {

  public int minRefillTimes(int[] plants, int Capacity1, int Capacity2) {
    int low = 0, high = plants.length - 1;
    int times = 2, i = Capacity1, j = Capacity2;

    while (low < high) {
      int left = i - plants[low], right = j - plants[high];
      if (left >= 0 && right >= 0) {
        if (left > right) {
          i -= plants[low++];
        } else {
          j -= plants[high--];
        }
      } else if (left < 0 && right < 0) {
        if (Capacity1 - plants[low] > Capacity2 - plants[high]) {
          i = Capacity1 - plants[low++];
        } else {
          j = Capacity2 - plants[high--];
        }
        times++;
      } else {
        if (left < 0) j -= plants[high--];
        else i -= plants[low++];
      }
    }

    if (i+j < plants[low]) times++;

    return times;
  }

  public static int waterPlants(int[] plants, int cap1, int cap2) {
    // input validation not needed

    int can1 = 0;
    int can2 = 0;
    int lo = 0;
    int hi = plants.length - 1;
    int numRefils = 0;

    while (lo < hi) {
      if (can1 < plants[lo]) {
        can1 = cap1;
        ++numRefils;
      }
      if (can2 < plants[hi]) {
        can2 = cap2;
        ++numRefils;
      }

      can1 -= plants[lo++];
      can2 -= plants[hi--];
    }

    if (lo == hi && (plants[lo] > can1 + can2)) {
      return ++numRefils;
    } else {
      return numRefils;
    }
  }

  public static void main(String... args) {
    WateringFlowers wateringFlowers = new WateringFlowers();
    int[] plants = new int[]{2, 4, 3, 4, 5, 3, 1, 2};
//    int[] plants = new int[]{2, 4, 5, 1, 2};
    System.out.println(wateringFlowers.minRefillTimes(plants, 5, 7));
    System.out.println(waterPlants(plants, 5, 7));
  }
}
