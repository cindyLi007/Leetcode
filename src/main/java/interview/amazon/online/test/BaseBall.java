package interview.amazon.online.test;

import java.util.Stack;

/**
 * Created by ychang on 5/23/2017. Given a String array, each element can be a number or "X", "Z" or "+".
 * "X" means current score is double of preScore, "Z" means remove previous score, "+" means current score is the sum of
 * previous 2 scores
 */
public class BaseBall {
  public int calculateSum(String[] nums) {
    Stack<Integer> stack = new Stack();
    int sum=0;
    for (int i = 0; i<nums.length; i++) {
      switch (nums[i]) {
        case "X":
          stack.push(stack.peek()*2);
          sum+=stack.peek();
          break;
        case "Z":
          sum-=stack.pop();
          break;
        case "+":
          int prev = stack.pop();
          int temp = stack.peek() + prev;
          stack.push(prev);
          stack.push(temp);
          sum+=temp;
          break;
        default:
          sum+=Integer.parseInt(nums[i]);
          stack.push(Integer.parseInt(nums[i]));
      }
    }
    return sum;
  }
}
