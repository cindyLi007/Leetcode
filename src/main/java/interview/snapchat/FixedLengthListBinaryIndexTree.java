package interview.snapchat;

/*
 * Logically maintain a list of numbers. The length of the list is fixed and given in the beginning. Each number can be
 * either a 0 or 1. Initially all numbers are zeros.
 * port 2 operations on the list:
 * (1) flip a number (0->1, 1->0) at a given position.
 * (2) count the sum of numbers within a given range.
 */
// O(N), Space O(N)
public class FixedLengthListBinaryIndexTree {
    int[] tree;

    public FixedLengthListBinaryIndexTree(int size) {
        tree = new int[size+1]; // sum[i] is from [0, i-1]
    }

    void flip(int pos) {
       int originalVal = sum(pos, pos);
       pos++;
       int diff = originalVal == 0 ? 1 : -1;
       while (pos < tree.length) {
           tree[pos] += diff;
           pos += pos & (-pos);
       }
    }

    // O(1)
    int sum(int start, int end) {
        return getRange(end)-getRange(start-1);
    }

    private int getRange(int i) {
        i++;
        int sum = 0;
        while (i>0) {
            sum += tree[i];
            i -= i&(-i);
        }
        return sum;
    }


    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        FixedLengthListBinaryIndexTree fl = new FixedLengthListBinaryIndexTree(5);
        System.out.println(fl.sum(0, 4) + " should be 0");
        // 0, 0, 0, 1, 0
        fl.flip(3);
        System.out.println(fl.sum(0, 2) + " should be 0");
        System.out.println(fl.sum(2, 4) + " should be 1");
        // 0, 0, 1, 1, 0
        fl.flip(2);
        System.out.println(fl.sum(2, 4) + " should be 2");
        fl.flip(3);
        System.out.println(fl.sum(2, 4) + " should be 1");
        fl.flip(2);
        System.out.println(fl.sum(2, 4) + " should be 0");
        System.out.println(fl.sum(1, 4) + " should be 0");
    }
}
