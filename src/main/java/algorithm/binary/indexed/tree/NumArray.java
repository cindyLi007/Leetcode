package algorithm.binary.indexed.tree;

/**
 * Created by ychang on 11/27/2016.
 */
public class NumArray {
  private int[] tree;
  private int[] nums;

  public NumArray(int[] nums) {
    this.nums = nums;
    int sum;
    int lowbit;
    tree = new int[nums.length + 1];
    for (int i = 1; i < tree.length; i++) {
      sum = 0;
      lowbit = i & (-i);
      for (int j = i; j > i - lowbit; j--) {
        sum += nums[j - 1]; // this is shift from nums. tree[i] corresponding num[i-1]
      }
      tree[i] = sum;
    }
  }

  void update(int index, int val) {
    int diff = val - nums[index];
    nums[index] = val;
    // need change all tree elements which related to nums[i]
    // i should shift one to tree index
    for (int i=index+1; i<tree.length; i+=(i&(-i))) {
      tree[i] +=diff;
    }
  }

  public int sumRange(int i, int j) {
    return getSum(j) - getSum(i-1);
  }

  public int getSum(int index) {
    int sum=0;
    for (int i=index+1; i>0; i-=i&(-i)) {
      sum += tree[i];
    }
    return sum;
  }

  public static void main(String[] args) {
    int[] array = new int[]{1, 0, 2, 1, 1, 3, 0, 4, 2, 5, 2, 2, 3, 1, 0, 2};
    NumArray numArray = new NumArray(array);
    for (int i=0; i<array.length; i++) {
      System.out.println("sum of " + i + " is " + numArray.getSum(i));
    }
  }
}
