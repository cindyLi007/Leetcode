package algorithm.binary.indexed.tree;

/**
 * Created by ychang on 11/27/2016.
 */
public class NumArray {
  public int[] tree;

  public NumArray(int[] nums) {
    tree = new int[nums.length + 1];
    for (int i = 1; i < tree.length; i++) {
      update(i, nums[i-1]);
    }
  }

  void update(int index, int val) {
    int diff = val - sumRange(index, index);
    // 记住 update是越来越往大的数，getRangeSum 是越来越往小的数
    while (index < tree.length) {
      tree[index] += diff;
      // 在计算机中，负数以原码的补码形式表达, 补码为原码取反加一
      // 而一个数与他的补码"AND", 相当于erase所有的1, 只留下最右边的一位
      index += index & (-index);
    }
  }

  // from i to j inclusive
  public int sumRange(int i, int j) {
    return getSum(j) - getSum(i-1);
  }

  public int getSum(int index) {
    int sum=0;
    // 记住 update是越来越往大的数，getRangeSum 是越来越往小的数
    while (index > 0) {
      sum += tree[index];
      index -= index & (-index);
    }
    return sum;
  }

  public int size() {
    return tree.length;
  }

  public static void main(String[] args) {
    int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    NumArray numArray = new NumArray(array);
    for (int i=1; i<numArray.size(); i++) {
      System.out.println("sum of 1 to " + i + " is " + numArray.getSum(i) + ", ******** tree array " + i + " is " + numArray.tree[i]);
    }
    System.out.println("Before sum of 3 to 7 is " + numArray.sumRange(3, 7) );
    numArray.update(5, 15);
    System.out.println("After sum of 3 to 7 is " + numArray.sumRange(3, 7) );
  }
}
/*
**************************************
1 ****** 55 ******** 1
2 ****** 54 ******** 3
3 ****** 52 ******** 3
4 ****** 49 ******** 10
5 ****** 45 ******** 5
6 ****** 40 ******** 11
7 ****** 34 ******** 7
8 ****** 27 ******** 36
9 ****** 19 ******** 9
10 ****** 10 ******** 19
**************************************
 */