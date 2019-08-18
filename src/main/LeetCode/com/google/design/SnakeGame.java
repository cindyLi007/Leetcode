import java.util.*;

class SnakeGame {
    int[][] food;
    Deque<int[]> snake;
    int idx;
    Map<String, int[]> map;
    int w, h;

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.food = food;
        w=width;
        h=height;
        idx=0;
        snake = new LinkedList();
        snake.add(new int[]{0, 0});
        map = new HashMap<String, int[]>() {
            {
                put("L", new int[]{0, -1});
                put("R", new int[]{0, 1});
                put("U", new int[]{-1, 0});
                put("D", new int[]{1, 0});
            }
        };
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] pos = snake.getFirst();
        int[] d = map.get(direction);
        int r = pos[0]+d[0], c = pos[1]+d[1];

        if (r<0 || r>=h || c<0 || c>=w) return -1;

        int[] newPos = new int[]{r, c};
        // we could not directly compare 2 arrays or use newPos.equals(X) to compare elements in 2 arrays (will return falas)
        // but we could use Arrays.equals to compare 2 arrays elements
        if (idx<food.length && Arrays.equals(newPos, food[idx])) {
            idx++;
        } else {
            snake.removeLast();
        }
        // check whether new head is in the old body
        for (int[] old : snake) {
            if (old[0]==r && old[1]==c) return -1;
        }
        snake.addFirst(newPos);
        return snake.size()-1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */