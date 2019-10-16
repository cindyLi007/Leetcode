package algorithm.binary.indexed.tree;

public class FenwickTree_P {

  int[] array; // 1-indexed array, In this array We save cumulative information to perform efficient range queries and updates

  public FenwickTree_P(int size) {
    array = new int[size + 1];
  }

  /**
   * Range Sum query from 1 to ind ind is 1-indexed
   * Time-Complexity:    O(log(n))
   * @param ind index
   * @return sum
   */
  public int rsq(int ind) {
    assert ind > 0;
    int sum = 0;
    while (ind > 0) {
      sum += array[ind];
      //Extracting the portion up to the first significant one of the binary representation of 'ind' and decrementing ind by that number
      ind -= ind & (-ind);
    }

    return sum;
  }

  /**
   * Range Sum Query from a to b. Search for the sum from array index from a to b, a and b are 1-indexed
   * Time-Complexity:    O(log(n))
   * @param a left index @param b right index
   * @return sum
   */
  public int rsq(int a, int b) {
    assert b >= a && a > 0 && b > 0;
    return rsq(b) - rsq(a - 1);
  }

  /**
   * Update the array at ind and all the affected regions above ind, ind is 1-indexed
   * Time-Complexity:    O(log(n))
   */
  public void update(int ind, int value) {
    assert ind > 0;
    while (ind < array.length) {
      array[ind] += value;
      // Extracting the portion up to the first significant one of the binary representation of 'ind' and incrementing ind by that number
      // for example, if ind is 11 (1011), ind will increment 0001, then increment 2, then increment 4 (after the 1st increment, it always
      // follow 2, 4, 8, 16, 32
      ind += ind & (-ind);
    }
  }

  public int size() {
    return array.length - 1;
  }


  /**
   * Read the following commands:
   * init n     Initializes the array of size n all zeroes
   * set a b c    Initializes the array  with [a, b, c ...]
   * rsq a b      Range Sum Query for the range [a,b]
   * up  i v      Update the i position of the array with value v.
   * exit
   * <p>
   * The array is 1-indexed
   * Example:
   * set 1 2 3 4 5 6
   * rsq 1 3
   * Sum from 1 to 3 = 6
   * rmq 1 3
   * Min from 1 to 3 = 1
   * input up 1 3
   * [3,2,3,4,5,6]
   *
   * @param args the command-line arguments
   */
  public static void main(String[] args) {

    FenwickTree_P ft = new FenwickTree_P(16);

    for (int i = 1; i <= ft.size(); i++) {
      ft.update(i, i);
    }

    for (int i = 1; i <= ft.size(); i++) {
      System.out.print((ft.rsq(i, i) + " ****** "));
      System.out.print((ft.rsq(i, ft.size()) + " ******** "));
      System.out.println(ft.array[i]);
    }
    System.out.println("**************************************");

    System.out.println("before from 3 to 7 is " + ft.rsq(3, 7));
    ft.update(11, 10);
    System.out.println("after from 3 to 7 is " + ft.rsq(3, 7));
    System.out.println();
  }
}
