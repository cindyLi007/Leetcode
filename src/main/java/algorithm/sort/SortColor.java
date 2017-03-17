package algorithm.sort;

/**
 * Created by ychang on 1/22/2017.
 * Quick Sort, in-place and one time iterate. lt always is the first index of equals-to, after iteration, gt is the last
 * index of equals-to
 */
public class SortColor {
  public void sortColors(int[] nums) {
    int lt=0, gt=nums.length-1, i=lt;
    while (i<=gt) {
      switch (nums[i]) {
        case 0 : swap(nums, i++, lt++); break;
        case 2 : swap(nums, i, gt--); break;
        default : i++;
      }
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i]=nums[j];
    nums[j]=temp;
  }
}
