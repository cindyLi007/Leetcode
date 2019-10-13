package interview.zillow.onsite;

import java.util.ArrayDeque;
import java.util.Deque;

// Given a Prefix expression, convert it into a Postfix expression.
public class PrefixConvertToPostfix {

  // *+AB-CD => AB+CD-* *-A/BC-/AKL => ABC/-AK/L-*
  /**
   * 应该做的是先观察: 可以看到prefix是先有符号再有数字，而postfix是先有数字再有符号，而如果把它们还原成树状结构，其实它们的subtree is same
   * postfix在某种意义上是prefix的reverse. 所以我们可以对prefix倒序遍历
   */
  public static String convert(String prefix) {
    Deque<String> stack = new ArrayDeque<>();
    for (char c : new StringBuilder(prefix).reverse().toString().toCharArray()) {
      if (isOp(c)) {
        String op1 = stack.pop(), op2 = stack.pop();
        StringBuilder sb = new StringBuilder();
        sb.append(op1).append(op2).append(c);
        stack.push(sb.toString());
      } else {
        stack.push(String.valueOf(c));
      }
    }
    return stack.peek();
  }

  private static boolean isOp(char c) {
    return c == '+' || c == '*' || c == '/' || c == '-';
  }

  public static void main(String... args) {
    System.out.println(convert("*+AB-CD")); // should be "AB+CD-*"
    System.out.println(convert("*-A/BC-/AKL")); // should be "ABC/-AK/L-*"
    System.out.println(convert("*-abc")); // should be "ABC/-AK/L-*"
  }

}
