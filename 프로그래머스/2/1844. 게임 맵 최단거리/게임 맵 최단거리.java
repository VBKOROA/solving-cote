import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

  public int solution(int[][] maps) {
    int mapHeight = maps.length;
    int mapWidth = maps[0].length;

    if (mapHeight == mapWidth && mapHeight == 1) {
      return 1;
    }

    // x, y
    int[][] movements = new int[][]{
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    int destY = mapHeight - 1;
    int destX = mapWidth - 1;
    boolean[][] visited = new boolean[mapHeight][mapWidth];
    Deque<State> queue = new ArrayDeque<>();
    queue.addLast(new State(0, 0, 1));

    while (!queue.isEmpty()) {
      State state = queue.pollFirst();
      int depth = state.depth + 1;

      for (int[] movement : movements) {
        int newX = state.x + movement[0];
        int newY = state.y + movement[1];

        if (newX == destX && newY == destY) {
          return depth;
        }

        boolean isInMapsWidth = 0 <= newX && newX < mapWidth;
        boolean isInMapsHeight = 0 <= newY && newY < mapHeight;
        boolean isInMap = isInMapsWidth && isInMapsHeight;

        if (!isInMap) {
          continue;
        }

        boolean isPossiblePath = maps[newY][newX] == 1;

        if (!isPossiblePath) {
          continue;
        }

        if (visited[newY][newX]) {
          continue;
        }

        visited[newY][newX] = true;
        queue.addLast(new State(newX, newY, depth));
      }
    }

    return -1;
  }

  static class State {

    int x;
    int y;
    int depth;

    public State(int x, int y, int depth) {
      this.x = x;
      this.y = y;
      this.depth = depth;
    }
  }
}
