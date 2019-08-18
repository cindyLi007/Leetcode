package interview.snapchat;

/*
 * Logically maintain a list of numbers. The length of the list is fixed and given in the beginning. Each number can be
 * either a 0 or 1. Initially all numbers are zeros.
 * port 2 operations on the list:
 * (1) flip a number (0->1, 1->0) at a given position.
 * (2) count the sum of numbers within a given range.
 */
// O(N), Space O(N)
public class FixedLengthList {
    int[] nums;
    int[] sum;
    final int SIZE;

    public FixedLengthList(int size) {
        SIZE = size;
        nums = new int[size];
        sum = new int[size+1]; // sum[i] is from [0, i-1]
    }

    // when we flip a pos, we set the num array, we update the sum array [pos, SIZE] for each entry, -1/+1 O(n)
    void flip(int pos) {
        if (pos <0 || pos>=SIZE) return;
        int x = nums[pos];
        nums[pos] ^=1;
        int diff = nums[pos] - x;
        for (int i=pos; i<SIZE; i++) {
            sum[i+1] += diff;
        }
    }

    // O(1)
    int sum(int start, int end) {
        return sum[end+1]-sum[start];
    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        FixedLengthList fl = new FixedLengthList(5);
        System.out.println(fl.sum(0, 4));
        // 0, 0, 0, 1, 0
        fl.flip(3);
        System.out.println(fl.sum(0, 2));
        System.out.println(fl.sum(2, 4));
        fl.flip(2);
        System.out.println(fl.sum(2, 4));
        fl.flip(3);
        System.out.println(fl.sum(2, 4));
        fl.flip(2);
        System.out.println(fl.sum(2, 4));
    }
}
