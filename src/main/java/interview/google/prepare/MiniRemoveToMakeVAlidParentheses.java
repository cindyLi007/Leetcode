package interview.google.prepare;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MiniRemoveToMakeVAlidParentheses {

  public static String minRemoveToMakeValid(String s) {
    // first need make sure it is valid, so must loop through
    Stack<Integer> stack = new Stack();
    Set<Integer> set = new HashSet();
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<s.length(); i++) {
      char c = s.charAt(i);
      if (c==')') {
        if (stack.isEmpty()) set.add(i);
        else stack.pop();
      } else if (c=='(') {
        stack.push(i);
      }
    }
    set.addAll(stack);
    for (int i=0; i<s.length(); i++) {
      if (!set.contains(i)) sb.append(s.charAt(i));
    }
    return sb.toString();
  }

  public static void main(String... args) {
    System.out.println("result is " + minRemoveToMakeValid("))((")); // ""
    System.out.println("result is " + minRemoveToMakeValid("lee(t(c)o)de)")); // "lee(t(c)o)de", or "lee(t(co)de)" , "lee(t(c)ode)"
    System.out.println("result is " + minRemoveToMakeValid("a)b(c)d")); // "ab(c)d"
    System.out.println("result is " + minRemoveToMakeValid("(a(b(c)d)")); // "a(b(c)d)"
  }
}
