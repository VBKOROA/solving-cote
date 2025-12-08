import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

  private static final int WALL = 1;

  public int solution(int[][] board) {
    int height = board.length;
    int width = board[0].length;
    int[][][] minCosts = new int[height][width][5];
    PriorityQueue<DijkstraState> dijkstraQueue = new PriorityQueue<>(
        Comparator.comparingInt(state -> state.cost));

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        Arrays.fill(minCosts[i][j], Integer.MAX_VALUE);
      }
    }

    dijkstraQueue.offer(new DijkstraState(0, 0, 0, Direction.EMPTY));
    minCosts[0][0][0] = 0;

    while (!dijkstraQueue.isEmpty()) {
      var state = dijkstraQueue.poll();
      int curCost = state.cost;
      int curY = state.y;
      int curX = state.x;
      Direction curDirection = state.direction;

      if (curCost > minCosts[curY][curX][curDirection.index]) {
        continue;
      }

      for (Direction direction : Direction.values()) {
        if (direction == Direction.EMPTY) {
          continue;
        }

        int newY = curY + direction.getMovement()[0];
        int newX = curX + direction.getMovement()[1];
        boolean isInHeight = 0 <= newY && newY < height;
        boolean isInWidth = 0 <= newX && newX < width;

        if (!(isInHeight && isInWidth)) {
          continue;
        }

        if (board[newY][newX] == WALL) {
          continue;
        }

        int newCost = curCost + 100;

        if (Direction.isCorner(curDirection, direction)) {
          newCost += 500;
        }

        if (newCost < minCosts[newY][newX][direction.index]) {
          minCosts[newY][newX][direction.index] = newCost;
          dijkstraQueue.add(new DijkstraState(newY, newX, newCost, direction));
        }
      }
    }

    int finalMinCost = Integer.MAX_VALUE;

    for (int cost : minCosts[height - 1][width - 1]) {
      if (cost < finalMinCost) {
        finalMinCost = cost;
      }
    }

    return finalMinCost;
  }

  enum Direction {
    DOWN(new int[]{1, 0}, 1),
    UP(new int[]{-1, 0}, 2),
    RIGHT(new int[]{0, 1}, 3),
    LEFT(new int[]{0, -1}, 4),
    EMPTY(new int[]{0, 0}, 0);

    private final int[] movement;
    private final int index;

    Direction(int[] movement, int index) {
      this.movement = movement;
      this.index = index;
    }

    public static boolean isCorner(Direction curDirection, Direction toDirection) {
      if (curDirection == Direction.UP || curDirection == Direction.DOWN) {
        if (toDirection == Direction.LEFT || toDirection == Direction.RIGHT) {
          return true;
        }
      }

      if (curDirection == Direction.LEFT || curDirection == Direction.RIGHT) {
        if (toDirection == Direction.UP || toDirection == Direction.DOWN) {
          return true;
        }
      }

      return false;
    }

    public int[] getMovement() {
      return movement;
    }
  }

  static class DijkstraState {

    int y;
    int x;
    int cost;
    Direction direction;

    public DijkstraState(int y, int x, int cost, Direction direction) {
      this.y = y;
      this.x = x;
      this.direction = direction;
      this.cost = cost;
    }
  }
}
