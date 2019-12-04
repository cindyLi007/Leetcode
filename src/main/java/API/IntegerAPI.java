package API;

public class IntegerAPI {

  public static void main(String... args) {
    int x = 21; // 10101
    System.out.println("bit count of " + x + " is " + Integer.bitCount(x));
    System.out.println(new Integer(x).byteValue()); // 21, 没啥用
    System.out.println(x + " highest one bit is " + Integer.highestOneBit(x));
    System.out.println(x + " lowest one bit is " + Integer.lowestOneBit(x));
    int shiftOne = 1 << 3;
    System.out.println("1<<3 is " + shiftOne);

    boolean shiftOne4 = (x & (1 << 4)) != 0;
    System.out.println("check whether one bit if x is set " + shiftOne4);
    System.out.println(Integer.lowestOneBit(4) & 1<<2);
    System.out.println("1010101 int value is " + Integer.parseInt("1010101", 2));

    System.out.println(x + " binary string is " + Integer.toBinaryString(x));
    System.out.println(85 + " hex string is " + Integer.toHexString(85));

    // check whether a number is pow of 2
    int num = 16;
    boolean pow = (num & (num-1)) == 0;
    System.out.println("check whether a number is pow of 2 " + pow);

    // erase the most right one bit
    num = 1011100;
    int num_decimal = Integer.parseInt(String.valueOf(num), 2);
    System.out.println(num + " int value is " + num_decimal);
    num_decimal &= num_decimal - 1 ;
    System.out.println("erase the most right ont bit of " + num + " is " + num_decimal);

    x = 16;
    System.out.println(x & -x);

    x = (int)Math.ceil(Math.log((double) 7) / Math.log(2.0));
    int size = 2 * (int)Math.pow(2.0, x) - 1;
    System.out.println(size);

    x=36;
    System.out.println(36>>1);

  }
}
