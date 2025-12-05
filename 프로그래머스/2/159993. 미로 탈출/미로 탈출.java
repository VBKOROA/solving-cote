import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

  static final char START = 'S';
  static final char EXIT = 'E';
  static final char LEVER = 'L';
  static final char PATH = 'O';
  static final char WALL = 'X';
  static final int[][] MOVEMENTS = new int[][]{
      {1, 0},
      {-1, 0},
      {0, 1},
      {0, -1},
  };

  int mapsHeight;
  int mapsWidth;

  public int solution(String[] mapStrings) {
    mapsHeight = mapStrings.length;
    mapsWidth = mapStrings[0].length();
    char[][] map = new char[mapsHeight][mapsWidth];
    int startX = 0;
    int startY = 0;
    int leverX = 0;
    int leverY = 0;
    int exitX = 0;
    int exitY = 0;
    int time = 0;

    for (int i = 0; i < mapsHeight; i++) {
      for (int j = 0; j < mapsWidth; j++) {
        char letter = mapStrings[i].charAt(j);
        map[i][j] = letter;

        switch (letter) {
          case START:
            startY = i;
            startX = j;
            break;
          case LEVER:
            leverY = i;
            leverX = j;
            break;
          case EXIT:
            exitY = i;
            exitX = j;
        }
      }
    }

    // Lever 까지 최소 시간 구하기
    time = bfs(startX, startY, leverX, leverY, time, map);

    if (time == -1) {
      return -1;
    }

    time = bfs(leverX, leverY, exitX, exitY, time, map);

    return time;
  }

  private int bfs(int startX, int startY, int destX, int destY, int time, char[][] map) {
    boolean[][] visited = new boolean[mapsHeight][mapsWidth];
    Deque<State> queue = new ArrayDeque<>();
    visited[startY][startX] = true;
    queue.addLast(new State(startX, startY, time));

    while (!queue.isEmpty()) {
      State state = queue.pollFirst();
      int newTime = state.time + 1;

      for (int[] movement : MOVEMENTS) {
        int newX = state.x + movement[0];
        int newY = state.y + movement[1];

        if (newX == destX && newY == destY) {
          return newTime;
        }

        boolean isInHeight = 0 <= newY && newY < mapsHeight;
        boolean isInWidth = 0 <= newX && newX < mapsWidth;
        boolean isInMap = isInHeight && isInWidth;

        if (!isInMap) {
          continue;
        }

        boolean isPath = map[newY][newX] != WALL;

        if (!isPath) {
          continue;
        }

        if (visited[newY][newX]) {
          continue;
        }

        visited[newY][newX] = true;
        queue.addLast(new State(newX, newY, newTime));
      }
    }

    return -1;
  }

  static class State {

    int x;
    int y;
    int time;

    public State(int x, int y, int time) {
      this.x = x;
      this.y = y;
      this.time = time;
    }
  }
}
