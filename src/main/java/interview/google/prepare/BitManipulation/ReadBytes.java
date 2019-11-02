package interview.google.prepare.BitManipulation;

/**
 * Given a byte[] array, write a function byte[] readBits(int numBits) starting from LSB towards MSB. for ex, if function
 * called to read 3 bits, read the last 3 bits from the byte and mask the remaining bits with zero. The algorithm has to
 * be designed in such a way that we should read the bits based on the given input and save remaining bits for subsequent reads.
 */
public class ReadBytes {

  // Time: O(N), N is the length of original that is for copy
  public static byte[] readBits(int numBits, byte[] original) {
    // first we need extract the byte(s) from byte[], such as how many bytes we need (single or multiple)
    // M = ((numBits-1) / 8 + 1) is the total # of bytes, the 1st index of the result is (N-M)
    int N = original.length, M = (numBits - 1) / 8 + 1;

    // copy [1] to [M-1] bytes to res
    byte[] res = new byte[M];
    for (int i=1; i<M; i++) {
      res[M-i] = original[N-i];
    }

    // 2nd we only need mask the most left byte of the results, which is the byte[N-M], use T = (numBits-1) % 8 + 1
    // is how many bits we need for the most left byte, if T==8 we need not do anything, otherwise we need mask (8-T) bits
    int T = (numBits - 1) % 8 + 1;
    if (T==8) res[0] = original[N-M];

    // 3rd we can use (1<<T) - 1) & the most left byte to get the masked byte, & with the byte and copy all other byte after it to the res.
    else {
      int mask = (1<<T) - 1;
      res[0] = (byte)(original[N-M] & mask);
    }

    return res;
  }

  public static void main(String... args) {
    byte[] original = new byte[]{(byte)Integer.parseInt("01101111", 2), (byte)Integer.parseInt("01101001", 2), (byte)Integer.parseInt("01101100", 2), (byte)Integer.parseInt("11101111", 2)};
    byte[] res = readBits(12, original);
  }

}
