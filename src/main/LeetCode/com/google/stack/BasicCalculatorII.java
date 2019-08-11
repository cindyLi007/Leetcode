package com.google.stack;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        Stack<Character> op = new Stack();
        int res = 0;
        if (s.length()==0) return res;

        int n = 0;
        for (char c : s.toCharArray()) {
            if (c==' ') continue;
            if (Character.isDigit(c)) {
                n = n*10 + (c-'0');
            } else {
                stack.push(n);
                n=0;
                if (c=='+' || c=='-') {
                    process(stack, op);
                }
                op.push(c);
            }
        }
        stack.push(n);
        process(stack, op);
        return stack.pop();
    }

    private void process(Stack<Integer> stack, Stack<Character> op) {
        while (stack.size() >= 2) {
            int n2 = stack.pop(), n1 = stack.pop();
            char symbol = op.pop();
            int temp = 0;
            if (symbol == '+') temp = n1 + n2;
            else if (symbol == '-') temp = n1 - n2;
            else if (symbol == '/') temp = n1 / n2;
            else temp = n1 * n2;
            stack.push(temp);
        }
    }
    public static void main(String... args) {
        BasicCalculatorII basicCalculatorII = new BasicCalculatorII();
        int res = basicCalculatorII.calculate("100000000/1/2/3/4/5/6/7/8/9/10");
        System.out.println(res);
    }
}
