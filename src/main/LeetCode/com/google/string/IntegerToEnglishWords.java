package com.google.string;

/**
 * Created by ychang on 3/10/2017.
 */
public class IntegerToEnglishWords {
  final String[] DIGITS = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
  final String[] TENS = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
  final String[] THOUSANDS = new String[]{"Billion", "Million", "Thousand", ""};

  public String numberToWords(int num) {
    if (num==0)
      return DIGITS[num];

    StringBuilder sb = new StringBuilder();
    int i = 0, base = 1_000_000_000;
    while (num>0) {
      if (num/base>0) {
        String s = String.valueOf(num);
        /**
         * when num is 12,345,678 we only want 12, so we need (0, 2), the total length is 8, so we need the substring (0, len-(9-1*3)) which is (0, 2)
         * next time, num is 345,678, we only want 345, now we need (0, 3), the total length, is 6, so we need substring (0, len-(9-2*3)) which is (0, 3)
         * we choose 9 because billion is 1_000_000_000
         */
        sb.append(parse(Integer.parseInt(s.substring(0, s.length() - (9 - 3*i)))));
        sb.append(THOUSANDS[i] + " ");
      }
      num %= base;
      base /= 1000;
      i++;
    }
    return sb.toString().trim();
  }

  /**
   * this is not my solution
   * @param num
   * @return
   */
  public String numberToWords_reverse(int num) {
    if (num==0)
      return DIGITS[num];

    StringBuilder sb = new StringBuilder();
    int i = 3;
    while (num!=0) {
      int temp = num%1000;
      /**
       * notice only when temp!=0, we parse it. For example, 1,000,000, first temp=0, we did nothing, second round temp==0
       * we did nothing, finally temp=1, we append one million
       */
      if (temp!=0) {
        String s = parse(temp) + THOUSANDS[i] + " ";
        sb.insert(0, s);
      }
      i--;
      num /= 1000;
    }

    return sb.toString().trim();
  }

  private String parse(int num) {
    StringBuilder sb = new StringBuilder();
    if (num/100>0) {
      sb.append(DIGITS[num/100] + " " + "Hundred ");
      num %= 100;
    }
    if (num/10>=2) {
      sb.append(TENS[num/10] + " ");
      num %= 10;
    } else if (num/10==1) {
      sb.append(TENS[num] + " ");
      return sb.toString();
    }
    if (num>0) {
      sb.append(DIGITS[num] + " ");
    }
    return sb.toString();
  }
}
