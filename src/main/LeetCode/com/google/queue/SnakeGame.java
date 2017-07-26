package com.google.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by ychang on 6/23/2017.
 */
public class SnakeGame {
  final int W, H;
  int eat, foodIndex;
  int[][] food;
  Queue<Integer> body;
  Set<Integer> set;
  int[] curPos;

  /**
   * Initialize your data structure here.
   *
   * @param width  - screen width
   * @param height - screen height
   * @param food   - A list of food positions
   *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
   */
  public SnakeGame(int width, int height, int[][] food) {
    W = width;
    H = height;
    this.food = food;
    body = new LinkedList();
    body.offer(0);
    set = new HashSet();
    set.add(0);
    curPos = new int[]{0, 0};
  }

  /**
   * Moves the snake.
   *
   * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
   * @return The game's score after the move. Return -1 if game over.
   * Game over when snake crosses the screen boundary or bites its body.
   */
  public int move(String direction) {
    if (eat==-1)
      return -1;
    switch (direction) {
      case "U":
        curPos[0]--;
        break;
      case "D":
        curPos[0]++;
        break;
      case "L":
        curPos[1]--;
        break;
      case "R":
        curPos[1]++;
    }
    int head = curPos[0]*W + curPos[1];
    set.add(head);
    body.offer(head);
    /**
     * since body is a queue, peek() get the first element means the first-in element, which is the tail
     * new head is legal to be in old tail's position, remove from set temporarily, because when a food does appear on
     * the screen, it is guaranteed that it will not appear on a block occupied by the snake, so a food could not be in
     * the tail node, so when new head is in old tail, there must NO duplication.
      */
    set.remove(body.peek());
    if (curPos[0]<0 || curPos[0]>=H || curPos[1]<0 || curPos[1]>=W || set.contains(head)) {
      return eat = -1;
    }
    if (foodIndex<food.length && curPos[0]==food[foodIndex][0] && curPos[1]==food[foodIndex][1]) {
      foodIndex++;
      eat++;
      set.add(body.peek()); // snake body++, so add the tail back
    } else {
      /**
       * the reason we do not first poll from body, only after we make sure snake does not eat food, we poll the tail node is we
       * must keep tail node in the end of the body, if we first poll(), then offer back, the tail node will become the head of the body
       */
      body.poll();
    }
    return eat;
  }
}